package com.popokis.morci_travel_api.search;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder(toBuilder = true)
@JsonDeserialize(builder = SearchRequest.SearchRequestBuilder.class)
public class SearchRequest {
    int passengers;
    @NonNull String departure;
    @NonNull String arrival;
    @NonNull LocalDate departureDate;
    LocalDate returnDate;
}
