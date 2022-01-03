package com.example.creditsaisonassignment.exchanges;

import com.example.creditsaisonassignment.models.CardStats;
import lombok.Data;

import java.util.List;

@Data
public class GetCardStatsResponse {
    private Boolean success;
    private List<CardStats> cardStatsList;

}
