package com.popokis.morci_travel_api.search;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1")
public class SearchController {

    @PostMapping("/search")
    public @ResponseBody String search(@RequestBody SearchRequest searchRequest) {
        return "";
    }
}
