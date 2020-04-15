package com.popokis.morci_travel_api.domain.model.event;

import com.popokis.morci_travel_api.domain.model.search.Search;
import com.popokis.morci_travel_api.domain.model.search.SearchStartedEvent;

public class DomainEventFactory implements EventFactory {
    @Override
    public SearchStartedEvent searchStartedEvent(Search search) {
        return SearchStartedEvent.builder().search(search).build();
    }
}
