package com.popokis.morci_travel_api.search;

import com.popokis.morci_travel_api.application.sse.SseApplicationService;
import com.popokis.morci_travel_api.application.verticle.EventFactory;
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
    private final EventFactory eventFactory;

    @SneakyThrows
    public UUID search(SearchRequest request) {
        Customer customer = new Customer();
        UUID searchId = customer.makeSearch();
        sseApplicationService.create(searchId.toString());
        eventBus.send(
                VerticleAddress.SEARCH_START.getAddress(),
                eventFactory.searchStartedEvent(searchId, request)
        );
        return searchId;
    }
}
