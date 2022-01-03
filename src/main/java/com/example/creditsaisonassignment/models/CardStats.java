package com.example.creditsaisonassignment.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CardStats {
    private String cardNumber;
    private int hits;
    private LocalDate firstTimestamp;
    private LocalDate latestTimestamp;
}
