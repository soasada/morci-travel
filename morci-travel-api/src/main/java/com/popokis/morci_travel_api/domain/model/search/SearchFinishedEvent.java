package com.popokis.morci_travel_api.domain.model.search;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.popokis.morci_travel_api.domain.model.event.Event;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@JsonDeserialize(builder = SearchFinishedEvent.SearchFinishedEventBuilder.class)
public class SearchFinishedEvent implements Event {
    String searchId;

    @Override
    public String address() {
        return "search.finish";
    }
}
