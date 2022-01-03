package com.example.creditsaisonassignment.dto_dummy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bin {
    private Number number;
    private String scheme;
    private String type;
    private String brand;
    private Country country;
    private Boolean prepaid;
    private Bank bank;
}
