package com.example.springhomework1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Springhomework1Application {

    public static void main(String[] args) {

        SpringApplication.run(Springhomework1Application.class, args);
    }

}
