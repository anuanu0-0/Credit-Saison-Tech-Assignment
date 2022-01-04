package com.example.creditsaisonassignment.repositoryServices;

import com.example.creditsaisonassignment.models.CardStatsEntity;

import java.util.List;

public interface CardStatsRepositoryService {
    List<CardStatsEntity> getStatistics();
    void saveCardStats(String cardNumber);

}
