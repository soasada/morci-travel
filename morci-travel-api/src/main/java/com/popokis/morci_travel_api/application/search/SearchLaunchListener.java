package com.popokis.morci_travel_api.application.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.popokis.morci_travel_api.application.event.DefaultEventListener;
import com.popokis.morci_travel_api.application.sse.SseApplicationService;
import com.popokis.morci_travel_api.domain.model.event.EventFactory;
import com.popokis.morci_travel_api.domain.model.event.EventPublisher;
import com.popokis.morci_travel_api.domain.model.search.SearchLaunchedEvent;
import io.vertx.core.eventbus.EventBus;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

public class SearchLaunchListener extends DefaultEventListener<SearchLaunchedEvent> {

    private final SseApplicationService sseApplicationService;
    private final EventPublisher eventPublisher;
    private final EventFactory eventFactory;

    public SearchLaunchListener(EventBus eventBus,
                                ObjectMapper mapper,
                                SseApplicationService sseApplicationService,
                                EventPublisher eventPublisher,
                                EventFactory eventFactory) {
        super(eventBus, mapper);
        this.sseApplicationService = sseApplicationService;
        this.eventPublisher = eventPublisher;
        this.eventFactory = eventFactory;
    }

    @Override
    public void listen(SearchLaunchedEvent event) {
        SseEmitter emitter = sseApplicationService.get(event.getSearch().getId());
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(1000, 7000));
            SearchResponse response = SearchResponse.builder()
                    .company("Flight company " + event.getRequestNumber())
                    .departureTime(LocalDateTime.of(event.getSearch().getDepartureDate(), LocalTime.now().plusHours(1)))
                    .arrivalTime(LocalDateTime.of(event.getSearch().getDepartureDate().plusDays(1), LocalTime.now()))
                    .price(BigDecimal.TEN)
                    .build();
            emitter.send(SseEmitter.event().id(event.getSearch().getId()).data(response).name("search-result"));
            eventPublisher.publish(eventFactory.searchLaunchFinishedEvent(event.getTotalRequests(), event.getSearch().getId()));
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Class<SearchLaunchedEvent> eventType() {
        return SearchLaunchedEvent.class;
    }

    @Override
    public String address() {
        return "search.launch";
    }
}
