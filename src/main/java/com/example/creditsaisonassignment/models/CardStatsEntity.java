package com.example.creditsaisonassignment.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
//@AllArgsConstructor
//@RequiredArgsConstructor
//@Document(collection="stats")
public class CardStatsEntity {
    @Id
    private String cardNumber;
    private int hits;
    private int firstTimestamp;
    private int latestTimestamp;
}
