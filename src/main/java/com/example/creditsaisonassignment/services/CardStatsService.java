package com.example.creditsaisonassignment.services;

import com.example.creditsaisonassignment.dto.Card;
import com.example.creditsaisonassignment.exchanges.GetCardStatsResponse;

public interface CardStatsService {
    void saveCardStats(String cardNumber);
    GetCardStatsResponse getStatistics();
}
