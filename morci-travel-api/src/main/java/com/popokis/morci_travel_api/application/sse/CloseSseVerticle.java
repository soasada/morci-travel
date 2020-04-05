package com.popokis.morci_travel_api.application.sse;

import com.popokis.morci_travel_api.application.VerticleAddress;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CloseSseVerticle extends AbstractVerticle {

    private final EventBus eventBus;
    private final SseApplicationService sseApplicationService;

    @Override
    public void start() throws Exception {
        eventBus.consumer(
                VerticleAddress.SSE_CLOSE_REQUESTS.getAddress(),
                (Message<String> message) -> sseApplicationService.get(message.body()).complete()
        );
    }
}
