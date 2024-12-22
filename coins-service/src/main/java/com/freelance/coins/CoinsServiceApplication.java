package com.freelance.coins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing
public class CoinsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoinsServiceApplication.class, args);
    }

}
