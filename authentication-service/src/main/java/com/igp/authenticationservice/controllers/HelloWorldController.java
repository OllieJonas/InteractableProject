package com.igp.authenticationservice.controllers;

import org.springframework.web.bind.annotation.*;

@RestController("/hello")
public class HelloWorldController {

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
    public String helloWorld(@PathVariable("name") String string) {
        return String.format("Hello %s!", string);
    }
}
