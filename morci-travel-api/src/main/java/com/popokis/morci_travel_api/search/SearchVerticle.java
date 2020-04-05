package com.popokis.morci_travel_api.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.popokis.morci_travel_api.application.sse.SseApplicationService;
import com.popokis.morci_travel_api.application.sse.SseCounterVerticle;
import com.popokis.morci_travel_api.application.verticle.ConsumerVerticle;
import com.popokis.morci_travel_api.application.verticle.VerticleAddress;
import io.vertx.core.eventbus.EventBus;
import lombok.Builder;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class SearchVerticle extends ConsumerVerticle<SearchVerticle.SearchVerticleRequest> {

    private final SseApplicationService sseApplicationService;

    public SearchVerticle(EventBus eventBus, SseApplicationService sseApplicationService, ObjectMapper mapper) {
        super(eventBus, VerticleAddress.SEARCH_REQUESTS.getAddress(), mapper);
        this.sseApplicationService = sseApplicationService;
    }

    @Override
    public void consume(SearchVerticleRequest payload) {
        SseEmitter emitter = sseApplicationService.get(payload.searchId);
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(1000, 10000));
            SearchResponse response = SearchResponse.builder()
                    .company("Flight company " + payload.i)
                    .departureTime(LocalDateTime.of(payload.searchRequest.getDepartureDate(), LocalTime.now().plusHours(1)))
                    .arrivalTime(LocalDateTime.of(payload.searchRequest.getDepartureDate().plusDays(1), LocalTime.now()))
                    .price(BigDecimal.TEN)
                    .build();
            emitter.send(SseEmitter.event().id(payload.searchId).data(response).name("search-result"));
            eventBus.send(
                    VerticleAddress.SSE_COUNTER_REQUESTS.getAddress(),
                    mapper.writeValueAsString(SseCounterVerticle.SseCounterVerticleRequest.builder()
                            .max(payload.max)
                            .searchId(payload.searchId)
                            .build()
                    )
            );
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Class<SearchVerticleRequest> getPayloadType() {
        return SearchVerticleRequest.class;
    }

    @Value
    @Builder(toBuilder = true)
    @JsonDeserialize(builder = SearchVerticleRequest.SearchVerticleRequestBuilder.class)
    public static class SearchVerticleRequest {
        int i;
        String searchId;
        SearchRequest searchRequest;
        int max;
    }
}
