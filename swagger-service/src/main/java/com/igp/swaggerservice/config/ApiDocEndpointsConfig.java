package com.igp.swaggerservice.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "api-docs.endpoints")
public class ApiDocEndpointsConfig {

    private List<ApiDocEndpoint> endPoints;

    @Data
    public static class ApiDocEndpoint {
        private String gatewayPrefix;
        private String serviceUrl;
        private String servicePath;
    }
}
