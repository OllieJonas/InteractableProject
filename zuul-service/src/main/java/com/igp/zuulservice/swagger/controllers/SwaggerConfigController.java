package com.igp.zuulservice.swagger.controllers;

import com.igp.zuulservice.swagger.config.ApiDocsEndpointsConfiguration;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SwaggerConfigController {

    private SwaggerUrlsConfig urlsConfig;

    private final ApiDocsEndpointsConfiguration apiDocsEndpointsConfiguration;

    @Autowired
    public SwaggerConfigController(ApiDocsEndpointsConfiguration apiDocsEndpointsConfiguration) {
        this.apiDocsEndpointsConfiguration = apiDocsEndpointsConfiguration;
    }

    @GetMapping("/swagger-config.json")
    public SwaggerUrlsConfig swaggerConfig() {
        return getUrlsConfig();
    }

    /**
     * Lazy getter for URLs config
     *
     * @return URLS Config
     */
    public SwaggerUrlsConfig getUrlsConfig() {
        if (urlsConfig == null) {
            this.urlsConfig = new SwaggerUrlsConfig(apiDocsEndpointsConfiguration.getEndPoints()
                    .stream()
                    .flatMap((map -> map.entrySet()
                            .stream()
                            .map(entry -> SwaggerUrlsConfig.SwaggerUrl.of(
                                    entry.getKey(),
                                    entry.getValue().getGatewayPrefix() + entry.getValue().getServicePath()))))
                    .collect(Collectors.toList()));
        }
        return urlsConfig;
    }

    @Data
    @Configuration
    @AllArgsConstructor
    public static class SwaggerUrlsConfig {
        private List<SwaggerUrl> urls;

        @Data
        @AllArgsConstructor(staticName = "of")
        public static class SwaggerUrl {
            private String name;
            private String url;
        }
    }
}
