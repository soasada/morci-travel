package com.popokis.morci_travel_api.application.search;

import com.popokis.morci_travel_api.domain.model.search.Search;
import com.popokis.morci_travel_api.helper.SearchRequestHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SearchMapperTest {

    @Autowired
    private SearchMapper searchMapper;

    @Test
    void shouldMapASearchRequestToASearchEntity() {
        SearchRequest searchRequest = SearchRequestHelper.oneway();
        Search search = searchMapper.toSearch(searchRequest);
        assertEquals(searchRequest.getPassengers(), search.getPassengers());
    }
}