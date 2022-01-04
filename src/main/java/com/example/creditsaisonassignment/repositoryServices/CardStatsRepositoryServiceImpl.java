package com.example.creditsaisonassignment.repositoryServices;

import com.example.creditsaisonassignment.models.CardStatsEntity;
import com.example.creditsaisonassignment.repository.CardStatsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CardStatsRepositoryServiceImpl implements  CardStatsRepositoryService{

    private final CardStatsRepository cardStatsRepository;
    private static final Logger log = LoggerFactory.getLogger(CardStatsRepositoryServiceImpl.class);

    public CardStatsRepositoryServiceImpl(CardStatsRepository cardStatsRepository) {
        this.cardStatsRepository = cardStatsRepository;
    }

    @Override
    public List<CardStatsEntity> getStatistics() {
        log.info("------------------------------------");
        log.info("In repository services");
        Iterable<CardStatsEntity> iterable = cardStatsRepository.findAll();
        List<CardStatsEntity> statsList = new ArrayList<>();
        iterable.forEach(statsList::add);
        return statsList;
    }

    /**
     * Check if card already exists in DB,
     * If not, set hit count to 1 and first timestamp to current time
     * If already exists, increment the hit count and update the latest timestamp.
     * */
    @Override
    public void saveCardStats(String cardNumber) {
        CardStatsEntity cardStatsEntity;

        if(cardStatsExists(cardNumber)) {
            cardStatsEntity = cardStatsRepository.findByCardNumber(cardNumber);

            int currentHitCount = cardStatsEntity.getHits();
            cardStatsEntity.setHits(currentHitCount+1);
        } else {
            cardStatsEntity = new CardStatsEntity();
            cardStatsEntity.setCardNumber(cardNumber);
            cardStatsEntity.setHits(1);
            cardStatsEntity.setFirstTimestamp(new Random(100).nextInt());
        }

        cardStatsEntity.setLatestTimestamp(new Random(100).nextInt());

        cardStatsRepository.save(cardStatsEntity);
    }

    private Boolean cardStatsExists(String cardNumber) {
        return cardStatsRepository.existsByCardNumber(cardNumber);
    }
}
