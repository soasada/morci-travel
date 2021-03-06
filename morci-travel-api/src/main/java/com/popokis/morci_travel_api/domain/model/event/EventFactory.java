package com.popokis.morci_travel_api.domain.model.event;

import com.popokis.morci_travel_api.domain.model.search.Search;
import com.popokis.morci_travel_api.domain.model.search.SearchFinishedEvent;
import com.popokis.morci_travel_api.domain.model.search.SearchLaunchFinishedEvent;
import com.popokis.morci_travel_api.domain.model.search.SearchLaunchedEvent;
import com.popokis.morci_travel_api.domain.model.search.SearchStartedEvent;

public interface EventFactory {
    SearchStartedEvent searchStartedEvent(Search search);

    SearchLaunchedEvent searchLaunchedEvent(int requestNumber, Search search, int totalRequests);

    SearchLaunchFinishedEvent searchLaunchFinishedEvent(int max, String searchId);

    SearchFinishedEvent searchFinishedEvent(String searchId);
}
