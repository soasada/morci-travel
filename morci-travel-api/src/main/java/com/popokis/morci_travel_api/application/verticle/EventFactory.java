package com.popokis.morci_travel_api.application.verticle;

import com.popokis.morci_travel_api.search.SearchRequest;

import java.util.UUID;

public interface EventFactory {
    String searchStartedEvent(UUID searchId, SearchRequest searchRequest);
}
