package com.example.gettingfamiliar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class GettingFamiliarApplication {
    public static void main(String[] args) {
        SpringApplication.run(GettingFamiliarApplication.class, args);
    }
}
