package com.popokis.morci_travel_api.domain.model.customer;

import com.popokis.morci_travel_api.domain.model.search.Search;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;

class CustomerSearchTest {

    @Test
    void aCustomerShouldBeAbleToMakeASearch() {
        Customer customer = new Customer();
        customer.makesASearch(Search.builder()
                .passengers(5)
                .departure("AGP")
                .arrival("BAR")
                .departureDate(LocalDate.now())
                .returnDate(LocalDate.now())
                .build()
        );
        assertFalse(customer.searchHistory().isEmpty());
    }
}