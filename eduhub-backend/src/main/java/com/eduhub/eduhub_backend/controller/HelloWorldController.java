package com.eduhub.eduhub_backend.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final Environment environment;

    public HelloWorldController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/env")
    public String getEnvironmentVariables() {

        String port = environment.getProperty("server.port");
        String appName = environment.getProperty("spring.application.name");

        return "App Name: " + appName + " Port: " + port;
    }
}