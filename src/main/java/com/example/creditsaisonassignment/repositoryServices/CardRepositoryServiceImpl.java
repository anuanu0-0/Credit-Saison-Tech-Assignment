package com.example.creditsaisonassignment.repositoryServices;

import com.example.creditsaisonassignment.dto.Card;
import com.example.creditsaisonassignment.models.CardEntity;
import com.example.creditsaisonassignment.models.CardStatsEntity;
import com.example.creditsaisonassignment.repository.CardRepository;
import com.example.creditsaisonassignment.services.BinServiceProviderImpl;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardRepositoryServiceImpl implements CardRepositoryService{
    private final ModelMapper modelMapper;
    private final CardRepository cardRepository;
    private static final Logger log = LoggerFactory.getLogger(BinServiceProviderImpl.class);


    @Autowired
    public CardRepositoryServiceImpl(ModelMapper modelMapper, CardRepository cardRepository) {
        this.modelMapper = modelMapper;
        this.cardRepository = cardRepository;
    }

    /**
     * Get card details given a card number
     * */
    @Override
    public Card getCardDetails(String cardNumber) {
        Optional<CardEntity> cardEntity = cardRepository.findByCardNumber(cardNumber);
        if(cardEntity.isPresent()) {
            return modelMapper.map(cardEntity.get(), Card.class);
        }
        return null;
    }

    /**
     * Get all the cards which where previously searched along with their statistics
     * */
    @Override
    public List<CardStatsEntity> getCardStatsList() {
        return null;
    }

    /**
     * Return if the searched card already exists in the repository
     * */
    @Override
    public Boolean cardExists(String cardNumber) {
        return cardRepository.existsByCardNumber(cardNumber);
    }

    /**
     * Save the card searched for if it doesn't already exist in the DB
     * */
    @Override
    public void saveCard(Card card, String cardNumber) {
        log.info("---------------------------------------------");
        log.info("Saving card {}", cardNumber + ", " + card);

        CardEntity cardEntity = modelMapper.map(card, CardEntity.class);
        cardEntity.setCardNumber(cardNumber);

        cardRepository.save(cardEntity);
    }

}
