package com.example.creditsaisonassignment.services;

import com.example.creditsaisonassignment.dto.Card;
import com.example.creditsaisonassignment.exceptions.CardServiceException;
import com.example.creditsaisonassignment.exchanges.GetCardResponse;
import com.example.creditsaisonassignment.exchanges.GetCardStatsResponse;

public interface CardDetailService {
    GetCardResponse getCardDetails(String cardNumber) throws CardServiceException;
}
