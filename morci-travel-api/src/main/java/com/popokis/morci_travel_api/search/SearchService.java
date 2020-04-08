package com.popokis.morci_travel_api.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.popokis.morci_travel_api.application.sse.SseApplicationService;
import com.popokis.morci_travel_api.application.verticle.VerticleAddress;
import com.popokis.morci_travel_api.domain.model.Customer;
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

    @SneakyThrows
    public UUID search(SearchRequest request) {
        Customer customer = new Customer();
        UUID searchId = customer.makeSearch();
        sseApplicationService.create(searchId.toString());
        eventBus.send(
                VerticleAddress.SEARCH_STARTED.getAddress(),
                mapper.writeValueAsString(new SearchVerticle.SearchVerticleRequest(searchId.toString(), request))
        );
        return searchId;
    }
}
