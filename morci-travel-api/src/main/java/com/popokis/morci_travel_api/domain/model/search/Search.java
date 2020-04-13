package com.popokis.morci_travel_api.domain.model.search;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@EqualsAndHashCode
public class Search {

    @Getter
    private final UUID id;

    public Search() {
        this.id = UUID.randomUUID();
    }
}
