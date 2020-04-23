package com.popokis.morci_travel_api.domain.model.event;

public interface EventListener<T extends Event> {
    void listen(T event);

    Class<T> eventType();

    String address();
}
