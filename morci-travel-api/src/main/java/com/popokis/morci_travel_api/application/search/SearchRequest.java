package com.popokis.morci_travel_api.application.search;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Value
@Builder(toBuilder = true)
@JsonDeserialize(builder = SearchRequest.SearchRequestBuilder.class)
public class SearchRequest {
    @Min(1)
    int passengers;
    @NotBlank
    @Size(max = 3)
    String departure;
    @NotBlank
    @Size(max = 3)
    String arrival;
    @NotNull
    LocalDate departureDate;
    LocalDate returnDate;
}
