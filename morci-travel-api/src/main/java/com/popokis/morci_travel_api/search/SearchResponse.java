package com.popokis.morci_travel_api.search;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
@Builder(toBuilder = true)
@JsonDeserialize(builder = SearchResponse.SearchResponseBuilder.class)
public class SearchResponse {
    String company;
    LocalDateTime departureTime;
    LocalDateTime arrivalTime;
    BigDecimal price;
}
