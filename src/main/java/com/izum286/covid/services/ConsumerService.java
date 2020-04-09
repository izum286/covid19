package com.izum286.covid.services;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ConsumerService {
    boolean sendToDb(String s) throws JsonProcessingException;
}
