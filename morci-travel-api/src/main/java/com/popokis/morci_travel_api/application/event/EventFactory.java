package com.popokis.morci_travel_api.application.event;

import com.popokis.morci_travel_api.search.SearchRequest;

import java.util.UUID;

public interface EventFactory {
    String searchStartedEvent(UUID searchId, SearchRequest searchRequest);

    String searchLaunchedEvent(int requestNumber, String searchId, SearchRequest searchRequest, int totalRequests);
}
