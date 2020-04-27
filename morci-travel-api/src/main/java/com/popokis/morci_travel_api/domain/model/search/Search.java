package com.popokis.morci_travel_api.domain.model.search;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

import static java.util.Objects.nonNull;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder(toBuilder = true)
public class Search {

    @EqualsAndHashCode.Include
    private String id;
    private int passengers;
    private String departure;
    private String arrival;
    private LocalDate departureDate;
    private LocalDate returnDate;

    public boolean isRoundTrip() {
        return nonNull(returnDate);
    }

    public static SearchBuilder builder() {
        return new CustomSearchBuilder();
    }

    private static class CustomSearchBuilder extends SearchBuilder {
        @Override
        public Search build() {
            super.id(UUID.randomUUID().toString());
            return super.build();
        }
    }
}
