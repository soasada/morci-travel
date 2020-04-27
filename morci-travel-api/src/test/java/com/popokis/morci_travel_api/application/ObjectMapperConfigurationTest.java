package com.popokis.morci_travel_api.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.popokis.morci_travel_api.application.search.SearchRequest;
import com.popokis.morci_travel_api.helper.SearchRequestHelper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ObjectMapperConfigurationTest {

    @Autowired
    private ObjectMapper objectMapper;

    @SneakyThrows
    @Test
    void shouldSerializeAnImmutableObject() {
        SearchRequest request = SearchRequestHelper.oneway();

        String jsonRequest = objectMapper.writeValueAsString(request);
        String expected = "{\"passengers\":5,\"departure\":\"AGP\",\"arrival\":\"BCN\",\"departureDate\":\"2020-04-28\"}";

        assertEquals(expected, jsonRequest);
    }

    @SneakyThrows
    @Test
    void shouldDeserializeAnImmutableObject() {
        String jsonRequest = "{\"passengers\":5,\"departure\":\"AGP\",\"arrival\":\"BCN\",\"departureDate\":\"2020-04-28\"}";

        SearchRequest deserializedRequest = objectMapper.readValue(jsonRequest, SearchRequest.class);
        SearchRequest expected = SearchRequestHelper.oneway();

        assertEquals(expected, deserializedRequest);
    }
}
