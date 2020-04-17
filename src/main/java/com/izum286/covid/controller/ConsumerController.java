package com.izum286.covid.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.izum286.covid.services.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ConsumerController {

    @Autowired
    ConsumerService service;

    @KafkaListener(topics = "USA")
    @GetMapping("print")
    public String printResult(String s) throws InterruptedException, JsonProcessingException {
        System.out.println("========================================");
        String first = "consumed data "+ s + " " + LocalDateTime.now();
        System.out.println(first);
        Thread.sleep(1000);
        String second = "data sent to process by service layer";
        System.out.println(second);
        Thread.sleep(1000);
        service.sendToDb("dsd");
        System.out.println("========================================");
        return "";
    }
}
