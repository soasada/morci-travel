package com.popokis.morci_travel_api.application.sse;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SseApplicationServiceTest {

    @Autowired
    private SseApplicationService sseApplicationService;

    @Test
    @SneakyThrows
    void shouldRemoveEmitterWhenCompletes() {
        SseEmitter emitter = sseApplicationService.create("TEST_ID");
        assertEquals(1, sseApplicationService.emitters.size());
        CompletableFuture.supplyAsync(() -> {
            try {
                emitter.send(SseEmitter.event().id("TEST_ID").data("data").name("test-name"));
                emitter.complete();
            } catch (Exception e) {

            }
            return "";
        });
        Thread.sleep(2000);
        SseEmitter sseEmitter = sseApplicationService.get("TEST_ID");
        assertEquals(0, sseApplicationService.emitters.size());
    }
}