package com.example.creditsaisonassignment.services;

import com.example.creditsaisonassignment.exchanges.GetCardStatsResponse;
import com.example.creditsaisonassignment.models.CardStatsEntity;
import com.example.creditsaisonassignment.repositoryServices.CardStatsRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardStatsServiceImpl implements CardStatsService {

    private static final Logger log = LoggerFactory.getLogger(CardStatsServiceImpl.class);
    private final CardStatsRepositoryService cardStatsRepositoryService;

    @Autowired
    public CardStatsServiceImpl(CardStatsRepositoryService cardStatsRepositoryService) {
        this.cardStatsRepositoryService = cardStatsRepositoryService;
    }

    @Override
    public void saveCardStats(String cardNumber) {
        cardStatsRepositoryService.saveCardStats(cardNumber);
    }

    /**
     * Get all the list of valid cards searched for with their hit count and timestamps.
     * */
    @Override
    public GetCardStatsResponse getStatistics() {
        List<CardStatsEntity> cardStatsEntityList = cardStatsRepositoryService.getStatistics();

        log.info("---------------------------------------------");
        log.info("Card Stats Response {} from DB ", cardStatsEntityList);
        GetCardStatsResponse getCardStatsResponse = new GetCardStatsResponse();
        getCardStatsResponse.setCardStatsList(cardStatsEntityList);
        return getCardStatsResponse;
    }
}
