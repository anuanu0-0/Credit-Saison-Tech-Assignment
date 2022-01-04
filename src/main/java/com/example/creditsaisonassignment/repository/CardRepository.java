package com.example.creditsaisonassignment.repository;

import com.example.creditsaisonassignment.models.CardEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends MongoRepository<CardEntity, String> {
    Optional<CardEntity> findByCardNumber(String cardNumber);
    Boolean existsByCardNumber(String cardNumber);
}
