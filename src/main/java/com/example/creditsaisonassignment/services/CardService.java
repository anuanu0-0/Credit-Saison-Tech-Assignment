package com.example.creditsaisonassignment.services;

import com.example.creditsaisonassignment.dto.Card;
import com.example.creditsaisonassignment.exchanges.GetCardResponse;
import com.example.creditsaisonassignment.exchanges.GetCardStatsResponse;

public interface CardService {
    GetCardResponse getCardDetails(String cardNumber);
    GetCardStatsResponse getCardStatsList();
}
