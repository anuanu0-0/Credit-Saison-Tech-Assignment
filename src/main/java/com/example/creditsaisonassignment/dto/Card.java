package com.example.creditsaisonassignment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Card {
    private String scheme;
    private String type;
    private Bank bank;
}
