package com.popokis.morci_travel_api.domain.model.customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class CustomerSearchTest {

    @Test
    void aCustomerShouldBeAbleToMakeASearch() {
        Customer customer = new Customer();
        customer.makesASearch();
        assertFalse(customer.searchHistory().isEmpty());
    }
}