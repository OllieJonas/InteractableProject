package com.igp.swaggerservice.controllers;

import com.igp.swaggerservice.config.ApiDocEndpointsConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@Slf4j
public class SwaggerConfigController {

    @Autowired
    private ApiDocEndpointsConfig apiDocEndpointsConfig;

    @GetMapping(path = "/config/raw")
    public List<ApiDocEndpointsConfig.ApiDocEndpoint> getEndPoints() {
        return apiDocEndpointsConfig.getEndPoints();
    }

    @GetMapping(path = "/config/count")
    public int getCount() {
        return apiDocEndpointsConfig.getEndPoints().size();
    }
}
