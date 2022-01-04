package com.example.creditsaisonassignment.repository;

import com.example.creditsaisonassignment.models.CardStatsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardStatsRepository extends MongoRepository<CardStatsEntity, String> {
    Boolean existsByCardNumber(String cardNumber);
    CardStatsEntity findByCardNumber(String cardNumber);
}
