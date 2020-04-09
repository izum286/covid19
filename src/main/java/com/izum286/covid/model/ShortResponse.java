package com.izum286.covid.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ShortResponse {
    private String country;
    private String lastUpdate;
    private int confirmed;
    private int deaths;
    private int recovered;
}
