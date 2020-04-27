package com.popokis.morci_travel_api.domain.model.customer;

import com.popokis.morci_travel_api.domain.model.search.Search;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {

    @EqualsAndHashCode.Include
    private String id;
    private List<Search> searches;

    public Customer() {
        this.id = UUID.randomUUID().toString();
        this.searches = new LinkedList<>();
    }

    public String makesASearch(Search search) {
        searches.add(search);
        return search.getId();
    }

    public List<Search> searchHistory() {
        return Collections.unmodifiableList(searches);
    }
}
