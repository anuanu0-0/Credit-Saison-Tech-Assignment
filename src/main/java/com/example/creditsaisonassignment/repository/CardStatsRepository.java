package com.example.creditsaisonassignment.repository;

import com.example.creditsaisonassignment.models.CardStatsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardStatsRepository extends MongoRepository<CardStatsEntity, String> {

}
