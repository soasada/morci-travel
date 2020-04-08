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
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

public class SearchWorkerVerticle extends ConsumerVerticle<SearchWorkerVerticle.SearchWorkerVerticleRequest> {

    private final SseApplicationService sseApplicationService;

    public SearchWorkerVerticle(EventBus eventBus, SseApplicationService sseApplicationService, ObjectMapper mapper) {
        super(eventBus, VerticleAddress.SEARCH_LAUNCHED.getAddress(), mapper);
        this.sseApplicationService = sseApplicationService;
    }

    @Override
    public void consume(SearchWorkerVerticleRequest payload) {
        SseEmitter emitter = sseApplicationService.get(payload.getSearchId());
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(1000, 10000));
            SearchResponse response = SearchResponse.builder()
                    .company("Flight company " + payload.getI())
                    .departureTime(LocalDateTime.of(payload.getSearchRequest().getDepartureDate(), LocalTime.now().plusHours(1)))
                    .arrivalTime(LocalDateTime.of(payload.getSearchRequest().getDepartureDate().plusDays(1), LocalTime.now()))
                    .price(BigDecimal.TEN)
                    .build();
            emitter.send(SseEmitter.event().id(payload.getSearchId()).data(response).name("search-result"));
            eventBus.send(
                    VerticleAddress.SSE_COUNTER_REQUESTS.getAddress(),
                    mapper.writeValueAsString(SseCounterVerticle.SseCounterVerticleRequest.builder()
                            .max(payload.getNumberOfRequests())
                            .searchId(payload.getSearchId())
                            .build()
                    )
            );
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Class<SearchWorkerVerticleRequest> getPayloadType() {
        return SearchWorkerVerticleRequest.class;
    }

    @Value
    @Builder(toBuilder = true)
    @JsonDeserialize(builder = SearchWorkerVerticleRequest.SearchWorkerVerticleRequestBuilder.class)
    public static class SearchWorkerVerticleRequest {
        int i;
        String searchId;
        SearchRequest searchRequest;
        int numberOfRequests;
    }
}
