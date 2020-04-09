package com.izum286.covid.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.izum286.covid.model.Covid19StatResponse;
import com.izum286.covid.model.ShortResponse;

import java.util.List;

public interface ProducerService {
    List<Covid19StatResponse> getStats(String country) throws JsonProcessingException;
    ShortResponse getSummaryByCountry(String country) throws JsonProcessingException;
}
