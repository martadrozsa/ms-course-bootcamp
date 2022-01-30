package com.martadrozsa.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    //implementa o padrão de projeto singleton para ter a disposição um objeto restTemplate para injetar em outros serviços
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
