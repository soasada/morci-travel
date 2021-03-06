package com.popokis.morci_travel_api.application.event;

import com.popokis.morci_travel_api.domain.model.event.EventFactory;
import com.popokis.morci_travel_api.domain.model.search.Search;
import com.popokis.morci_travel_api.domain.model.search.SearchFinishedEvent;
import com.popokis.morci_travel_api.domain.model.search.SearchLaunchFinishedEvent;
import com.popokis.morci_travel_api.domain.model.search.SearchLaunchedEvent;
import com.popokis.morci_travel_api.domain.model.search.SearchStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class DomainEventFactory implements EventFactory {
    @Override
    public SearchStartedEvent searchStartedEvent(Search search) {
        return SearchStartedEvent.builder().search(search).build();
    }

    @Override
    public SearchLaunchedEvent searchLaunchedEvent(int requestNumber, Search search, int totalRequests) {
        return SearchLaunchedEvent.builder()
                .requestNumber(requestNumber)
                .search(search)
                .totalRequests(totalRequests)
                .build();
    }

    @Override
    public SearchLaunchFinishedEvent searchLaunchFinishedEvent(int max, String searchId) {
        return SearchLaunchFinishedEvent.builder().max(max).searchId(searchId).build();
    }

    @Override
    public SearchFinishedEvent searchFinishedEvent(String searchId) {
        return SearchFinishedEvent.builder().searchId(searchId).build();
    }
}
