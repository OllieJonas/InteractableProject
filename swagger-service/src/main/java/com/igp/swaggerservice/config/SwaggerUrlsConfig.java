package com.igp.swaggerservice.config;

import java.util.List;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class SwaggerUrlsConfig {
    private List<SwaggerUrl> urls;
}
