package com.popokis.morci_travel_api.application.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.popokis.morci_travel_api.domain.model.event.Event;
import com.popokis.morci_travel_api.domain.model.event.EventListener;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class DefaultEventListener<T extends Event> extends AbstractVerticle implements EventListener<T> {

    protected final EventBus eventBus;
    protected final ObjectMapper mapper;

    @Override
    public void start() throws Exception {
        eventBus.consumer(address(), (Message<String> message) -> {
            try {
                T event = mapper.readValue(message.body(), eventType());
                listen(event);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
