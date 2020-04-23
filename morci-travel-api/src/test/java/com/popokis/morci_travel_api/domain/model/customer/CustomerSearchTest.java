package com.popokis.morci_travel_api.domain.model.customer;

import com.popokis.morci_travel_api.domain.model.search.Search;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;

class CustomerSearchTest {

    @Test
    void aCustomerShouldBeAbleToMakeASearch() {
        Customer customer = new Customer();
        customer.makesASearch(new Search(5, "AGP", "BAR", LocalDate.now(), LocalDate.now()));
        assertFalse(customer.searchHistory().isEmpty());
    }
}