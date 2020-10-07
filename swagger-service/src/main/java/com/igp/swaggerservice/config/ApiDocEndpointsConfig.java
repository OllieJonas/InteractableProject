package com.igp.swaggerservice.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "api-docs")
public class ApiDocEndpointsConfig {

    private List<Map<String, ApiDocEndpoint>> endPoints;

    @Data
    @NoArgsConstructor
    public static class ApiDocEndpoint {
        private String gatewayPrefix;
        private String serviceUrl;
        private String servicePath;
    }
}
