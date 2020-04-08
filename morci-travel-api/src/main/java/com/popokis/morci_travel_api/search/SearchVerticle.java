package com.popokis.morci_travel_api.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.popokis.morci_travel_api.application.verticle.ConsumerVerticle;
import com.popokis.morci_travel_api.application.verticle.VerticleAddress;
import io.vertx.core.eventbus.EventBus;
import lombok.Builder;
import lombok.SneakyThrows;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchVerticle extends ConsumerVerticle<SearchVerticle.SearchStartedEvent> {

    @Autowired
    public SearchVerticle(EventBus eventBus, ObjectMapper mapper) {
        super(eventBus, VerticleAddress.SEARCH_START.getAddress(), mapper);
    }

    @Override
    public void consume(SearchStartedEvent event) {
        final int numberOfRequests = 10; // calculate number of requests
        for (int i = 0; i < numberOfRequests; i++) {
            eventBus.send(
                    VerticleAddress.SEARCH_LAUNCHED.getAddress(),
                    createWorkerRequest(i, event.getSearchId(), event.getSearchRequest(), numberOfRequests)
            );
        }
    }

    @Override
    public Class<SearchStartedEvent> getEventType() {
        return SearchStartedEvent.class;
    }

    @SneakyThrows
    private String createWorkerRequest(int i, String searchId, SearchRequest request, int numberOfRequests) {
        return mapper.writeValueAsString(new SearchWorkerVerticle.SearchWorkerVerticleRequest(i, searchId, request, numberOfRequests));
    }

    @Value
    @Builder(toBuilder = true)
    @JsonDeserialize(builder = SearchStartedEvent.SearchStartedEventBuilder.class)
    public static class SearchStartedEvent {
        String searchId;
        SearchRequest searchRequest;
    }
}
