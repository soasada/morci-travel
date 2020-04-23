package com.popokis.morci_travel_api.domain.model.search;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

import static java.util.Objects.nonNull;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Search {

    @Getter
    @EqualsAndHashCode.Include
    private UUID id;
    private int passengers;
    private String departure;
    private String arrival;
    private LocalDate departureDate;
    private LocalDate returnDate;

    public Search(int passengers,
                  String departure,
                  String arrival,
                  LocalDate departureDate,
                  LocalDate returnDate) {
        this(UUID.randomUUID(), passengers, departure, arrival, departureDate, returnDate);
    }

    public boolean isRoundTrip() {
        return nonNull(returnDate);
    }
}
