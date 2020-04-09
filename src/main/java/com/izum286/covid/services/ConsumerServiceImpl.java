package com.izum286.covid.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.izum286.covid.model.ShortResponse;
import com.izum286.covid.repos.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    ProducerService service;

    @Autowired
    MainRepository repository;

    @Scheduled(fixedRate = 1000)
    @Override
    public boolean sendToDb() throws JsonProcessingException {
        ShortResponse response = service.getSummaryByCountry("USA");
        ShortResponse s = repository.save(response);
        return true;
    }
}
