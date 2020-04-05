package com.popokis.morci_travel_api.application.verticle;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum VerticleAddress {
    SEARCH_REQUESTS("search.requests"),
    SSE_CLOSE_REQUESTS("sse.close.requests"),
    SSE_COUNTER_REQUESTS("sse.counter.requests");

    private final String address;
}