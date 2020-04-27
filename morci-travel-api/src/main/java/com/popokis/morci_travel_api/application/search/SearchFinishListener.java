package com.popokis.morci_travel_api.application.search;

import com.popokis.morci_travel_api.application.sse.SseApplicationService;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SearchFinishListener extends AbstractVerticle {

    private final EventBus eventBus;
    private final SseApplicationService sseApplicationService;

    @Override
    public void start() throws Exception {
        eventBus.consumer(
                "search.finish",
                (Message<String> message) -> sseApplicationService.get(message.body()).complete()
        );
    }
}
