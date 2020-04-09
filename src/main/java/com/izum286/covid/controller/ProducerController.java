package com.izum286.covid.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.izum286.covid.model.Covid19StatResponse;
import com.izum286.covid.model.ShortResponse;
import com.izum286.covid.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProducerController {

    @Autowired
    ProducerService service;


    @RequestMapping(value = "/getAllRaw/{country}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Covid19StatResponse> get(@PathVariable String country) throws JsonProcessingException {
        return service.getStats(country);
    }

    @RequestMapping(value = "/getShort/{country}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ShortResponse getSummaryByCountry(@PathVariable String country) throws JsonProcessingException {
        return service.getSummaryByCountry(country);
    }

    @Scheduled(fixedRate = 1000)
    @RequestMapping(value = "/getShortScheduled", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ShortResponse getSchedule() throws JsonProcessingException {
        ShortResponse z = service.getSummaryByCountry("USA");
        System.out.println("done " + z.getDeaths() + " "+ z.getConfirmed());
        return z;
    }
}
