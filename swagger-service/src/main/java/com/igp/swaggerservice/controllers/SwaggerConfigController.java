package com.igp.swaggerservice.controllers;

import com.igp.swaggerservice.config.ApiDocEndpointsConfig;
import com.igp.swaggerservice.config.SwaggerUrl;
import com.igp.swaggerservice.config.SwaggerUrlsConfig;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class SwaggerConfigController {

    private final ApiDocEndpointsConfig apiDocEndpointsConfig;

    @Getter
    private final SwaggerUrlsConfig swaggerUrlsConfig;

    @Autowired
    public SwaggerConfigController(ApiDocEndpointsConfig apiDocEndpointsConfig) {
        this.apiDocEndpointsConfig = apiDocEndpointsConfig;
        Objects.requireNonNull(apiDocEndpointsConfig.getEndPoints());
        this.swaggerUrlsConfig = buildSwaggerConfig();
    }

    @GetMapping(path = "/config/raw")
    public List<Map<String, ApiDocEndpointsConfig.ApiDocEndpoint>> getEndPoints() {
        return apiDocEndpointsConfig.getEndPoints();
    }

    @GetMapping("/swagger-config.json")
    public SwaggerUrlsConfig swaggerConfig() {
        return swaggerUrlsConfig;
    }

    @SuppressWarnings("ConstantConditions")
    private SwaggerUrlsConfig buildSwaggerConfig() {
        return new SwaggerUrlsConfig(apiDocEndpointsConfig.getEndPoints()
                .stream()
                .flatMap(map -> map.entrySet()
                        .stream()
                        .map(entry -> SwaggerUrl.of(
                                entry.getKey(),
                                entry.getValue().getGatewayPrefix() + entry.getValue().getServicePath())))
                .collect(Collectors.toList()));
    }

    @GetMapping(path = "/config/count")
    public int getCount() {
        return apiDocEndpointsConfig.getEndPoints().size();
    }
}
