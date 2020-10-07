package com.igp.swaggerservice.config;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
public class SwaggerUrl {
    private String url;
    private String name;
}
