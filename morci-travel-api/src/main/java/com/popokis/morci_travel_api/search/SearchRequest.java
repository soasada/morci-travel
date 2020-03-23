package com.popokis.morci_travel_api.search;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder(toBuilder = true)
public class SearchRequest {
    JourneyType journeyType;
    int passengers;
    String departure;
    String arrival;
    LocalDate departureDate;
    LocalDate returnDate;

    public enum JourneyType {
        ONEWAY, ROUNDTRIP;

        public boolean isOneWay() {
            return this == ONEWAY;
        }
    }
}
