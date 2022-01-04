package com.example.creditsaisonassignment.services;

import com.example.creditsaisonassignment.repositoryServices.CardRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class BinStatsImpl implements BinStats{

    private final CardRepositoryService binStatsRepositoryService;

    @Autowired
    public BinStatsImpl(CardRepositoryService binStatsRepositoryService) {
        this.binStatsRepositoryService = binStatsRepositoryService;
    }

    @Override
    public String registerNewBin(String cardNumber) {
        return null;
    }

    @Override
    public Integer getHitCount(String cardNumber) {
        return 0;
    }
}
