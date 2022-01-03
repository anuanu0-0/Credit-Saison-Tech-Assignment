package com.example.creditsaisonassignment.dto_dummy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bank {
    private String name;
//    private String url;
//    private String phone;
//    private String city;
}
