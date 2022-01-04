package com.example.creditsaisonassignment.exchanges;

import com.example.creditsaisonassignment.models.CardStatsEntity;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class GetCardStatsResponse {
//    @NonNull
    private List<CardStatsEntity> cardStatsList;
}
