package com.izum286.covid.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Covid19StatResponse {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String city;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String province;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String country;
    private String lastUpdate;
    private String keyId;
    private int confirmed;
    private int deaths;
    private int recovered;
}
