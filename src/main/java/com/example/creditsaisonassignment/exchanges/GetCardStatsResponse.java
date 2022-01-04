package com.example.creditsaisonassignment.exchanges;

import com.example.creditsaisonassignment.models.CardStatsEntity;
import lombok.Data;

import java.util.List;

@Data
public class GetCardStatsResponse {
    private List<CardStatsEntity> cardStatsList;
}
