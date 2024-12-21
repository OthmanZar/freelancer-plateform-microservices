package com.freelance.offers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OffersServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(OffersServiceApplication.class, args);

    }

}
