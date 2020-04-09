package com.izum286.covid;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.izum286.covid.model.Covid19StatResponse;
import com.izum286.covid.services.ProducerService;
import com.izum286.covid.services.ProducerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CovidApplication {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(CovidApplication.class, args);

    }

}
