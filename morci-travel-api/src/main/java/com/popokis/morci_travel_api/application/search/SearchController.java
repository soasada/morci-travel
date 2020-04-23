package com.popokis.morci_travel_api.application.search;

import com.popokis.morci_travel_api.application.sse.SseApplicationService;
import com.popokis.morci_travel_api.domain.model.search.SearchService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/v1")
class SearchController {

    private final SearchService searchService;
    private final SseApplicationService sseApplicationService;
    private final SearchMapper mapper;

    @PostMapping("/search")
    public @ResponseBody UUID search(@Valid @RequestBody SearchRequest searchRequest) {
        return searchService.search(mapper.toSearch(searchRequest));
    }

    @GetMapping("/search/{searchId}/push")
    public SseEmitter getSseEmitter(@PathVariable UUID searchId) {
        return sseApplicationService.get(searchId.toString());
    }
}
