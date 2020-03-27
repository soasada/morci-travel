package com.popokis.morci_travel_api.search;

import com.popokis.morci_travel_api.application.sse.SseApplicationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/v1")
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
class SearchController {

    private final SseApplicationService sseApplicationService;

    @PostMapping("/search")
    public @ResponseBody UUID search(@RequestBody SearchRequest searchRequest) {
        UUID correlationId = UUID.randomUUID();
        SseEmitter emitter = sseApplicationService.create(correlationId.toString());
        CompletableFuture.supplyAsync(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    emitter.send(SseEmitter.event().id(correlationId.toString()).data(searchRequest).name("search-result"));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            emitter.complete();
            return "";
        });
        return correlationId;
    }

    @GetMapping("/sse/{correlationId}")
    public SseEmitter getSseEmitter(@PathVariable String correlationId) {
        return sseApplicationService.get(correlationId);
    }
}
