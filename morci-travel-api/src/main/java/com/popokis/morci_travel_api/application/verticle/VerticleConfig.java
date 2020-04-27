package com.popokis.morci_travel_api.application.verticle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.popokis.morci_travel_api.application.search.SearchFinishListener;
import com.popokis.morci_travel_api.application.search.SearchLaunchFinishListener;
import com.popokis.morci_travel_api.application.search.SearchLaunchListener;
import com.popokis.morci_travel_api.application.search.SearchStartListener;
import com.popokis.morci_travel_api.application.sse.SseApplicationService;
import com.popokis.morci_travel_api.domain.model.event.EventFactory;
import com.popokis.morci_travel_api.domain.model.event.EventPublisher;
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

    private final SearchFinishListener searchFinishListener;
    private final SearchLaunchFinishListener searchLaunchFinishListener;
    private final SearchStartListener searchStartListener;

    private final Vertx vertx;
    private final EventBus eventBus;
    private final SseApplicationService sseApplicationService;
    private final ObjectMapper mapper;
    private final EventPublisher eventPublisher;
    private final EventFactory eventFactory;

    @EventListener(ApplicationReadyEvent.class)
    public void deployVerticles() {
        vertx.deployVerticle(searchFinishListener);
        vertx.deployVerticle(searchLaunchFinishListener);
        vertx.deployVerticle(searchStartListener);
        DeploymentOptions optionsForSearchVerticle = new DeploymentOptions().setWorker(true);
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            vertx.deployVerticle(new SearchLaunchListener(eventBus, mapper, sseApplicationService, eventPublisher, eventFactory), optionsForSearchVerticle);
        }
        log.info("Verticles deployed");
    }
}
