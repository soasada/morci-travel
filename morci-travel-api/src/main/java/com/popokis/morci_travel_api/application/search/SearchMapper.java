package com.popokis.morci_travel_api.application.search;

import com.popokis.morci_travel_api.domain.model.search.Search;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SearchMapper {
    Search toSearch(SearchRequest searchRequest);
}
