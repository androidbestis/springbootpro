package com.adonai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Docker Compose + Spring Boot + Nginx + Mysql 实践
 */
@SpringBootApplication
public class ComposeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComposeApplication.class, args);
    }
}