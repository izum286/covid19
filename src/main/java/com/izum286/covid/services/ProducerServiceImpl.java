package com.izum286.covid.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.izum286.covid.model.Covid19StatResponse;
import com.izum286.covid.model.ShortResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService {
    final String baseUrl = "https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats";
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<Covid19StatResponse> getStats(String country) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com");
        headers.set("x-rapidapi-key", "aba52e6ff4mshc3d1d6050426c7cp177725jsne78c33c4c028");
        HttpEntity entity = new HttpEntity(headers);
        URI endpoint = UriComponentsBuilder.fromUriString(baseUrl)
                .queryParam("country", country).build().toUri();
        ResponseEntity<String> responseEntity = restTemplate.exchange(endpoint, HttpMethod.GET,
                entity, String.class);
        JsonNode jsonNode = objectMapper.readTree(responseEntity.getBody());
        String resp = jsonNode.get("data").get("covid19Stats").toString();
        List<Covid19StatResponse> lst = Arrays.asList(objectMapper.readValue(resp, Covid19StatResponse[].class));
        return lst;
    }

    @Override
    public ShortResponse getSummaryByCountry(String country) throws JsonProcessingException {
        int confirmed = 0;
        int death = 0;
        int recovered = 0;
        List<Covid19StatResponse> source = getStats(country);
        for (Covid19StatResponse c : source) {
            confirmed += c.getConfirmed();
            death += c.getDeaths();
            recovered+=c.getRecovered();
        }
        return ShortResponse.builder()
                .country(country)
                .confirmed(confirmed)
                .deaths(death).recovered(recovered).build();
    }
}
