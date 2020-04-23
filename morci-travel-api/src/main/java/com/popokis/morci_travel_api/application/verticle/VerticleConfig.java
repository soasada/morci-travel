package com.popokis.morci_travel_api.application.verticle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.popokis.morci_travel_api.application.sse.CompleteSseVerticle;
import com.popokis.morci_travel_api.application.sse.SseApplicationService;
import com.popokis.morci_travel_api.application.sse.SseCounterVerticle;
import com.popokis.morci_travel_api.application.search.SearchStartListener;
import com.popokis.morci_travel_api.application.search.SearchWorkerVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
class VerticleConfig {

    private final CompleteSseVerticle closeSseVerticle;
    private final SseCounterVerticle sseCounterVerticle;
    private final SearchStartListener searchVerticle;

    private final Vertx vertx;
    private final EventBus eventBus;
    private final SseApplicationService sseApplicationService;
    private final ObjectMapper mapper;

    @EventListener(ApplicationReadyEvent.class)
    public void deployVerticles() {
        vertx.deployVerticle(closeSseVerticle);
        vertx.deployVerticle(sseCounterVerticle);
        vertx.deployVerticle(searchVerticle);
        DeploymentOptions optionsForSearchVerticle = new DeploymentOptions().setWorker(true);
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            vertx.deployVerticle(new SearchWorkerVerticle(eventBus, sseApplicationService, mapper), optionsForSearchVerticle);
        }
        log.info("Verticles deployed");
    }
}
