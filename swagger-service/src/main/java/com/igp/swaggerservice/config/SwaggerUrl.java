package com.igp.swaggerservice.config;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor(staticName = "of")
@Data
public class SwaggerUrl {
    private String name;
    private String url;
}
