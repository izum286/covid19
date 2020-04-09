package com.izum286.covid.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.izum286.covid.model.ShortResponse;

public interface ConsumerService {
    boolean sendToDb() throws JsonProcessingException;
}
