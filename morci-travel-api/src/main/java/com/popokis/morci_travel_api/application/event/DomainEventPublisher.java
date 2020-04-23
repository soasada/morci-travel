package com.popokis.morci_travel_api.application.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.popokis.morci_travel_api.domain.model.event.Event;
import com.popokis.morci_travel_api.domain.model.event.EventPublisher;
import io.vertx.core.eventbus.EventBus;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DomainEventPublisher implements EventPublisher {

    private final EventBus eventBus;
    private final ObjectMapper mapper;

    @Override
    @SneakyThrows
    public <T extends Event> void publish(T event) {
        eventBus.send(event.address(), mapper.writeValueAsString(event));
    }
}
