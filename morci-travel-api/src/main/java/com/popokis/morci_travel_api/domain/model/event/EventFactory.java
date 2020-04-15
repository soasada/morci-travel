package com.popokis.morci_travel_api.domain.model.event;

import com.popokis.morci_travel_api.domain.model.search.Search;
import com.popokis.morci_travel_api.domain.model.search.SearchStartedEvent;

public interface EventFactory {
    SearchStartedEvent searchStartedEvent(Search search);
}
