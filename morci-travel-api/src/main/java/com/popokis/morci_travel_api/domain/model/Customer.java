package com.popokis.morci_travel_api.domain.model;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Customer {

    private final List<UUID> searches;

    public Customer() {
        this.searches = new LinkedList<>();
    }

    public UUID makeSearch() {
        UUID searchId = UUID.randomUUID();
        searches.add(searchId);
        return searchId;
    }
}
