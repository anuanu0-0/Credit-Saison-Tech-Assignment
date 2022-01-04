package com.example.creditsaisonassignment.repositoryServices;

import com.example.creditsaisonassignment.dto.Card;

public interface CardDetailRepositoryService {
    Card getCardDetails(String cardNumber);
    Boolean cardExists(String cardNumber);
    void saveCard(Card card, String cardNumber);
}
