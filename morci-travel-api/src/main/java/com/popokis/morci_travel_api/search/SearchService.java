package com.popokis.morci_travel_api.search;

import com.popokis.morci_travel_api.application.sse.SseApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
@AllArgsConstructor
public class SearchService {

    private final SseApplicationService sseApplicationService;
    private final TaskExecutor taskExecutor;

    public Future<Void> search(String searchId, SearchRequest request) {
        return CompletableFuture.supplyAsync(() -> {
            SseEmitter emitter = sseApplicationService.create(searchId);
            for (int i = 0; i < 10; i++) {
                CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(1000);
                        SearchResponse response = SearchResponse.builder()
                                .company("Flight company 1")
                                .departureTime(LocalDateTime.of(request.getDepartureDate(), LocalTime.now().plusHours(1)))
                                .arrivalTime(LocalDateTime.of(request.getDepartureDate().plusDays(1), LocalTime.now()))
                                .price(BigDecimal.TEN)
                                .build();
                        emitter.send(SseEmitter.event().id(searchId).data(response).name("search-result"));
                    } catch (Exception e) {
                        emitter.complete();
                        throw new RuntimeException(e);
                    }
                    return null;
                }, taskExecutor);
            }
            return null;
        }, taskExecutor);
    }
}
