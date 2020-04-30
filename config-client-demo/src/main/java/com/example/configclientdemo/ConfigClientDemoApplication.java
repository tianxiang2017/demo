package com.example.configclientdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientDemoApplication.class, args);
    }

    @Value("${foo:1}")
    String foo;

    @RequestMapping(value = "/hi")
    public String hi() {
        return "ConfigClientDemo foo=" + foo;
    }

}
