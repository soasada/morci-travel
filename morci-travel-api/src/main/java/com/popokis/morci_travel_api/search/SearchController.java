package com.popokis.morci_travel_api.search;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/v1")
@Slf4j
class SearchController {

    private static final Map<String, SseEmitter> EMITTERS = new ConcurrentHashMap<>();

    @PostMapping("/search")
    public @ResponseBody UUID search(@RequestBody SearchRequest searchRequest) {
        UUID customerId = UUID.randomUUID();
        SseEmitter emitter = createEmitter(customerId.toString());
        CompletableFuture.supplyAsync(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    emitter.send(SseEmitter.event().id(customerId.toString()).data(searchRequest).name("search-result"));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            emitter.complete();
            return "";
        });
        return customerId;
    }

    @GetMapping("/sse/{customerId}")
    public SseEmitter getSseEmitter(@PathVariable String customerId) {
        return EMITTERS.get(customerId);
    }

    private SseEmitter createEmitter(String customerId) {
        SseEmitter emitter = new SseEmitter(60 * 1000L);

        emitter.onCompletion(() -> EMITTERS.remove(customerId));
        emitter.onTimeout(() -> EMITTERS.remove(customerId));
        emitter.onError(e -> EMITTERS.remove(customerId));

        EMITTERS.put(customerId, emitter);

        return emitter;
    }
}
