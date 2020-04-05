package com.popokis.morci_travel_api.search;

import com.popokis.morci_travel_api.application.sse.SseApplicationService;
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

import java.util.UUID;

@RestController
@RequestMapping("/v1")
@Slf4j
@AllArgsConstructor
class SearchController {

    private final SearchService searchService;
    private final SseApplicationService sseApplicationService;

    @PostMapping("/search")
    public @ResponseBody UUID search(@RequestBody SearchRequest searchRequest) {
        return searchService.search(searchRequest);
    }

    @GetMapping("/search/{searchId}/push")
    public SseEmitter getSseEmitter(@PathVariable String searchId) {
        return sseApplicationService.get(searchId);
    }
}
