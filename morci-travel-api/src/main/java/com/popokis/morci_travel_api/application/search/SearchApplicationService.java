package com.popokis.morci_travel_api.application.search;

import com.popokis.morci_travel_api.application.sse.SseApplicationService;
import com.popokis.morci_travel_api.domain.model.customer.Customer;
import com.popokis.morci_travel_api.domain.model.event.EventFactory;
import com.popokis.morci_travel_api.domain.model.event.EventPublisher;
import com.popokis.morci_travel_api.domain.model.search.Search;
import com.popokis.morci_travel_api.domain.model.search.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class SearchApplicationService implements SearchService {

    private final SseApplicationService sseApplicationService;
    private final EventPublisher eventPublisher;
    private final EventFactory eventFactory;

    @Override
    public UUID search(Search search) {
        Customer customer = new Customer();
        UUID searchId = customer.makesASearch(search);
        sseApplicationService.create(searchId.toString());
        eventPublisher.publish(eventFactory.searchStartedEvent(search));
        return searchId;
    }
}
