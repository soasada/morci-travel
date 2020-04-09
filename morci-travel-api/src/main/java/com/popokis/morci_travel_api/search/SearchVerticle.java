package com.popokis.morci_travel_api.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.popokis.morci_travel_api.application.event.EventFactory;
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

    private final EventFactory eventFactory;

    @Autowired
    public SearchVerticle(EventBus eventBus, ObjectMapper mapper, EventFactory eventFactory) {
        super(eventBus, VerticleAddress.SEARCH_START.getAddress(), mapper);
        this.eventFactory = eventFactory;
    }

    @Override
    public void consume(SearchStartedEvent event) {
        final int totalRequests = 10; // calculate number of requests
        for (int i = 0; i < totalRequests; i++) {
            eventBus.send(
                    VerticleAddress.SEARCH_LAUNCH.getAddress(),
                    eventFactory.searchLaunchedEvent(i, event.getSearchId(), event.getSearchRequest(), totalRequests)
            );
        }
    }

    @Override
    public Class<SearchStartedEvent> getEventType() {
        return SearchStartedEvent.class;
    }

    @Value
    @Builder(toBuilder = true)
    @JsonDeserialize(builder = SearchStartedEvent.SearchStartedEventBuilder.class)
    public static class SearchStartedEvent {
        String searchId;
        SearchRequest searchRequest;
    }
}
