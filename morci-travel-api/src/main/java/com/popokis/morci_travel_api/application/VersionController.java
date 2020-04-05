package com.popokis.morci_travel_api.application;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class VersionController {

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/app/version")
    public VersionResponse getSseEmitter() {
        return new VersionResponse(appVersion);
    }

    @lombok.Value
    @Builder(toBuilder = true)
    @JsonDeserialize(builder = VersionResponse.VersionResponseBuilder.class)
    private static class VersionResponse {
        String version;
    }
}
