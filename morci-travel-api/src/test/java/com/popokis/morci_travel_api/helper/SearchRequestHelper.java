package com.popokis.morci_travel_api.helper;

import com.popokis.morci_travel_api.search.SearchRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchRequestHelper {

    public static SearchRequest oneway() {
        return SearchRequest.builder()
                .passengers(5)
                .departure("AGP")
                .arrival("BCN")
                .departureDate(LocalDate.of(2020, 4, 28))
                .build();
    }

    public static SearchRequest roundtrip() {
        return SearchRequest.builder()
                .passengers(5)
                .departure("AGP")
                .arrival("BCN")
                .departureDate(LocalDate.now().plusDays(1))
                .returnDate(LocalDate.now().plusDays(5))
                .build();
    }
}
