package com.popokis.morci_travel_api.application.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.popokis.morci_travel_api.application.event.DefaultEventListener;
import com.popokis.morci_travel_api.application.verticle.VerticleAddress;
import com.popokis.morci_travel_api.domain.model.event.EventFactory;
import com.popokis.morci_travel_api.domain.model.event.EventPublisher;
import com.popokis.morci_travel_api.domain.model.search.SearchStartedEvent;
import io.vertx.core.eventbus.EventBus;
import org.springframework.stereotype.Component;

@Component
public class SearchStartListener extends DefaultEventListener<SearchStartedEvent> {

    private final EventPublisher eventPublisher;
    private final EventFactory eventFactory;

    public SearchStartListener(EventBus eventBus, ObjectMapper mapper, EventPublisher eventPublisher, EventFactory eventFactory) {
        super(eventBus, mapper);
        this.eventPublisher = eventPublisher;
        this.eventFactory = eventFactory;
    }

    @Override
    public void listen(SearchStartedEvent event) {
        final int totalRequests = 10; // calculate number of requests
        for (int i = 0; i < totalRequests; i++) {
            eventPublisher.publish(eventFactory);
            eventBus.send(
                    VerticleAddress.SEARCH_LAUNCH.getAddress(),
                    eventFactory.searchLaunchedEvent(i, event.getSearchId(), event.getSearchRequest(), totalRequests)
            );
        }
    }

    @Override
    public Class<SearchStartedEvent> eventType() {
        return SearchStartedEvent.class;
    }

    @Override
    public String address() {
        return "search.start";
    }
}
