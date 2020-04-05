package com.popokis.morci_travel_api.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.popokis.morci_travel_api.application.VerticleAddress;
import com.popokis.morci_travel_api.application.sse.SseApplicationService;
import io.vertx.core.eventbus.EventBus;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class SearchService {

    private final SseApplicationService sseApplicationService;
    private final EventBus eventBus;
    private final ObjectMapper mapper;

    public UUID search(SearchRequest request) {
        final int n = 10; // calculate number of requests
        final UUID searchId = UUID.randomUUID();
        sseApplicationService.create(searchId.toString());

        for (int i = 0; i < n; i++) {
            eventBus.send(
                    VerticleAddress.SEARCH_REQUESTS.getAddress(),
                    createRequest(i, searchId, request, n)
            );
        }

        return searchId;
    }

    @SneakyThrows
    private String createRequest(int i, UUID searchId, SearchRequest request, int n) {
        return mapper.writeValueAsString(new SearchVerticle.SearchVerticleRequest(i, searchId.toString(), request, n));
    }
}
