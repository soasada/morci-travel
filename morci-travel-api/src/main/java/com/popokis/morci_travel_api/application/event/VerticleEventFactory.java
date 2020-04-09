package com.popokis.morci_travel_api.application.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.popokis.morci_travel_api.search.SearchRequest;
import com.popokis.morci_travel_api.search.SearchVerticle;
import com.popokis.morci_travel_api.search.SearchWorkerVerticle;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class VerticleEventFactory implements EventFactory {

    private final ObjectMapper mapper;

    @Override
    @SneakyThrows
    public String searchStartedEvent(UUID searchId, SearchRequest searchRequest) {
        return mapper.writeValueAsString(
                SearchVerticle.SearchStartedEvent.builder()
                        .searchId(searchId.toString())
                        .searchRequest(searchRequest)
                        .build()
        );
    }

    @Override
    @SneakyThrows
    public String searchLaunchedEvent(int requestNumber, String searchId, SearchRequest searchRequest, int totalRequests) {
        return mapper.writeValueAsString(
                SearchWorkerVerticle.SearchLaunchedEvent.builder()
                        .requestNumber(requestNumber)
                        .searchId(searchId)
                        .searchRequest(searchRequest)
                        .totalRequests(totalRequests)
                        .build()
        );
    }
}
