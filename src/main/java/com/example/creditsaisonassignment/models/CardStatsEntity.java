package com.example.creditsaisonassignment.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection="stats")
public class CardStatsEntity {
    @Id
    private String cardNumber;
    private int hits;
    private LocalDate firstTimestamp;
    private LocalDate latestTimestamp;
}
