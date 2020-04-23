package com.popokis.morci_travel_api.application.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.popokis.morci_travel_api.application.event.DefaultEventListener;
import com.popokis.morci_travel_api.domain.model.event.EventFactory;
import com.popokis.morci_travel_api.domain.model.event.EventPublisher;
import com.popokis.morci_travel_api.domain.model.search.SearchLaunchFinishedEvent;
import io.vertx.core.eventbus.EventBus;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SearchLaunchFinishListener extends DefaultEventListener<SearchLaunchFinishedEvent> {

    private final Map<String, Integer> numberOfRequestsPerSearchId;
    private final EventPublisher eventPublisher;
    private final EventFactory eventFactory;

    public SearchLaunchFinishListener(EventBus eventBus, ObjectMapper mapper, EventPublisher eventPublisher, EventFactory eventFactory) {
        super(eventBus, mapper);
        this.numberOfRequestsPerSearchId = new HashMap<>();
        this.eventPublisher = eventPublisher;
        this.eventFactory = eventFactory;
    }

    @Override
    public void listen(SearchLaunchFinishedEvent event) {
        String searchId = event.getSearchId();
        if (numberOfRequestsPerSearchId.containsKey(searchId)) {
            numberOfRequestsPerSearchId.put(searchId, numberOfRequestsPerSearchId.get(searchId) + 1);
        } else {
            numberOfRequestsPerSearchId.put(searchId, 1);
        }

        int counter = numberOfRequestsPerSearchId.get(searchId);

        if (counter == event.getMax()) {
            eventPublisher.publish(eventFactory.searchFinishedEvent(searchId));
            numberOfRequestsPerSearchId.remove(searchId);
        }
    }

    @Override
    public Class<SearchLaunchFinishedEvent> eventType() {
        return SearchLaunchFinishedEvent.class;
    }

    @Override
    public String address() {
        return "search.launch.finish";
    }
}
