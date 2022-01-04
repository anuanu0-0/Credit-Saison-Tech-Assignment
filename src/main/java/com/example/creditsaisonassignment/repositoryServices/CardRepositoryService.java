package com.example.creditsaisonassignment.repositoryServices;

import com.example.creditsaisonassignment.dto.Card;
import com.example.creditsaisonassignment.models.CardStatsEntity;

import java.util.List;

public interface CardRepositoryService {
    Card getCardDetails(String cardNumber);
    List<CardStatsEntity> getCardStatsList();
    Boolean cardExists(String cardNumber);
    void saveCard(Card card, String cardNumber);
}
