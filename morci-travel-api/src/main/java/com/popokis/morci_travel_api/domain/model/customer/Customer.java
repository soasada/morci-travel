package com.popokis.morci_travel_api.domain.model.customer;

import com.popokis.morci_travel_api.domain.model.search.Search;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Customer {

    private final String id;
    private final List<Search> searches;

    public Customer() {
        this.id = UUID.randomUUID().toString();
        this.searches = new LinkedList<>();
    }

    public UUID makeASearch() {
        Search search = new Search();
        searches.add(search);
        return search.getId();
    }

    public List<Search> searchHistory() {
        return Collections.unmodifiableList(searches);
    }
}
