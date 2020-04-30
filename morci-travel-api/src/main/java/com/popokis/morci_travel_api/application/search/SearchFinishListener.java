package com.popokis.morci_travel_api.application.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.popokis.morci_travel_api.application.event.DefaultEventListener;
import com.popokis.morci_travel_api.application.sse.SseApplicationService;
import com.popokis.morci_travel_api.domain.model.search.SearchFinishedEvent;
import io.vertx.core.eventbus.EventBus;
import org.springframework.stereotype.Component;

@Component
public class SearchFinishListener extends DefaultEventListener<SearchFinishedEvent> {

    private final SseApplicationService sseApplicationService;

    public SearchFinishListener(EventBus eventBus, ObjectMapper mapper, SseApplicationService sseApplicationService) {
        super(eventBus, mapper);
        this.sseApplicationService = sseApplicationService;
    }

    @Override
    public void listen(SearchFinishedEvent event) {
        sseApplicationService.get(event.getSearchId()).complete();
    }

    @Override
    public Class<SearchFinishedEvent> eventType() {
        return SearchFinishedEvent.class;
    }

    @Override
    public String address() {
        return "search.finish";
    }
}
