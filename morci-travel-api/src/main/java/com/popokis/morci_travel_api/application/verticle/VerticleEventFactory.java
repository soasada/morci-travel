package com.popokis.morci_travel_api.application.verticle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.popokis.morci_travel_api.search.SearchRequest;
import com.popokis.morci_travel_api.search.SearchVerticle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class VerticleEventFactory implements EventFactory {

    private final ObjectMapper mapper;

    @Override
    public String searchStartedEvent(UUID searchId, SearchRequest searchRequest) {
        return mapper.writeValueAsString(new SearchVerticle.SearchStartedEvent(searchId.toString(), searchRequest));
    }
}
