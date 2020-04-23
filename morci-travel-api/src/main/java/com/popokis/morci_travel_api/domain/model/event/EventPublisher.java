package com.popokis.morci_travel_api.domain.model.event;

public interface EventPublisher {
    <T extends Event> void publish(T event);
}
