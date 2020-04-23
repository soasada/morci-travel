package com.popokis.morci_travel_api.application.sse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.popokis.morci_travel_api.application.event.DefaultEventListener;
import com.popokis.morci_travel_api.application.verticle.VerticleAddress;
import io.vertx.core.eventbus.EventBus;
import lombok.Builder;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SseCounterVerticle extends DefaultEventListener<SseCounterVerticle.SseCounterVerticleRequest> {

    private final Map<String, Integer> numberOfRequestsPerSearchId;

    @Autowired
    public SseCounterVerticle(EventBus eventBus, ObjectMapper mapper) {
        super(eventBus, VerticleAddress.SSE_COUNTER_REQUESTS.getAddress(), mapper);
        this.numberOfRequestsPerSearchId = new HashMap<>();
    }

    @Override
    public void consume(SseCounterVerticleRequest payload) {
        String searchId = payload.searchId;
        if (numberOfRequestsPerSearchId.containsKey(searchId)) {
            numberOfRequestsPerSearchId.put(searchId, numberOfRequestsPerSearchId.get(searchId) + 1);
        } else {
            numberOfRequestsPerSearchId.put(searchId, 1);
        }

        int counter = numberOfRequestsPerSearchId.get(searchId);

        if (counter == payload.max) {
            eventBus.send(VerticleAddress.SSE_CLOSE_REQUESTS.getAddress(), searchId);
            numberOfRequestsPerSearchId.remove(searchId);
        }
    }

    @Override
    public Class<SseCounterVerticleRequest> getEventType() {
        return SseCounterVerticleRequest.class;
    }

    @Value
    @Builder(toBuilder = true)
    @JsonDeserialize(builder = SseCounterVerticleRequest.SseCounterVerticleRequestBuilder.class)
    public static class SseCounterVerticleRequest {
        int max;
        String searchId;
    }
}
