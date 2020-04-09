package com.izum286.covid.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ConsumerServiceImpl implements ConsumerService {

//    @Autowired
//    ProducerService service;
//
//    @Autowired
//    MainRepository repository;

    @KafkaListener(topics = "USA")
    @Override
    public boolean sendToDb(String s) throws JsonProcessingException {
        System.out.println("consumed data "+s + " " + LocalDateTime.now());
        return true;
    }
}
