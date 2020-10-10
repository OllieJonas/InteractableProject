package com.igp.zuulservice.swagger;

import com.igp.zuulservice.swagger.controllers.SwaggerConfigController;
import com.igp.zuulservice.util.TriFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Configuration
public class SwaggerAggregator implements SwaggerResourcesProvider {

    private final SwaggerConfigController.SwaggerUrlsConfig config;

    private final BiFunction<String, String, SwaggerResource> urlToSwaggerResource = swaggerResource();

    @Autowired
    public SwaggerAggregator(SwaggerConfigController.SwaggerUrlsConfig config) {
        this.config = config;
    }

    @Override
    public List<SwaggerResource> get() {
        return config.getUrls()
                .stream()
                .map(service -> urlToSwaggerResource.apply(service.getName(), service.getUrl()))
                .collect(Collectors.toList());
    }

    private BiFunction<String, String, SwaggerResource> swaggerResource() {
        return (name, location) -> {
            SwaggerResource resource = new SwaggerResource();
            resource.setName(name);
            resource.setLocation(location);
            return resource;
        };

    }
}
