package com.sunonebytes.openapi.client;

import com.sunonebytes.openapi.client.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ ApplicationProperties.class })
public class OpenapiClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenapiClientApplication.class, args);
    }

}
