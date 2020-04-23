package com.popokis.morci_travel_api.domain.model.search;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.popokis.morci_travel_api.domain.model.event.Event;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@JsonDeserialize(builder = SearchLaunchedEvent.SearchLaunchedEventBuilder.class)
public class SearchLaunchedEvent implements Event {
    int requestNumber;
    Search search;
    int totalRequests;

    @Override
    public String address() {
        return "search.launch";
    }
}
