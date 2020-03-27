package com.popokis.morci_travel_api.application.sse;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SseApplicationService {

    private static final long SSE_TIMEOUT_ONE_MINUTE = 60 * 1000L;

    final Map<String, SseEmitter> emitters;

    public SseApplicationService() {
        this.emitters = new ConcurrentHashMap<>();
    }

    public SseEmitter create(String correlationId) {
        SseEmitter emitter = new SseEmitter(SSE_TIMEOUT_ONE_MINUTE);

        emitter.onCompletion(() -> emitters.remove(correlationId));
        emitter.onTimeout(() -> emitters.remove(correlationId));
        emitter.onError(e -> emitters.remove(correlationId));

        emitters.put(correlationId, emitter);

        return emitter;
    }

    public SseEmitter get(String correlationId) {
        return emitters.get(correlationId);
    }
}
