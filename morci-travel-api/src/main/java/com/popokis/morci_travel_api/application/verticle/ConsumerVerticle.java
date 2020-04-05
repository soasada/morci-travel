package com.popokis.morci_travel_api.application.verticle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class ConsumerVerticle<T> extends AbstractVerticle {

    protected final EventBus eventBus;
    private final String address;
    protected final ObjectMapper mapper;

    @Override
    public void start() throws Exception {
        eventBus.consumer(address, (Message<String> message) -> {
            try {
                T payload = mapper.readValue(message.body(), getPayloadType());
                consume(payload);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public abstract void consume(T payload);

    public abstract Class<T> getPayloadType();
}
