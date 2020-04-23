package com.popokis.morci_travel_api.application.event;

import com.popokis.morci_travel_api.domain.model.event.EventFactory;
import com.popokis.morci_travel_api.domain.model.search.Search;
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
}
