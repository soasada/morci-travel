package com.popokis.morci_travel_api.application.search;

import com.popokis.morci_travel_api.domain.model.search.Search;
import org.mapstruct.Mapper;

@Mapper
public interface SearchMapper {
    Search toSearch(SearchRequest searchRequest);
}
