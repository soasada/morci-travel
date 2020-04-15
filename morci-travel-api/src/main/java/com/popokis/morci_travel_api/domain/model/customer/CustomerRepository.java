package com.popokis.morci_travel_api.domain.model.customer;

import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface CustomerRepository extends Repository<Customer, UUID> {
    Customer save(Customer customer);
}
