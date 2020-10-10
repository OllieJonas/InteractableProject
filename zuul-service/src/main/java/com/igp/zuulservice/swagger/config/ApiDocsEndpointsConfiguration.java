package com.igp.zuulservice.swagger.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "api-docs")
public class ApiDocsEndpointsConfiguration {

    private List<Map<String, Endpoint>> endPoints;

    @Data
    @NoArgsConstructor
    public static class Endpoint {
        private String gatewayPrefix;
        private String serviceUrl;
        private String servicePath;
    }
}
