package com.example.creditsaisonassignment.services;

import com.example.creditsaisonassignment.dto.Card;
import com.example.creditsaisonassignment.exceptions.CardServiceException;
import com.example.creditsaisonassignment.exchanges.GetCardResponse;
import com.example.creditsaisonassignment.repositoryServices.CardDetailRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CardDetailServiceImpl implements CardDetailService {

    private final String URL_TEMPLATE = "https://lookup.binlist.net/$CARD_NUMBER";
    private static final Logger log = LoggerFactory.getLogger(CardDetailServiceImpl.class);
    private final RestTemplate restTemplate;

    private final CardDetailRepositoryService cardDetailRepositoryService;


    @Autowired
    public CardDetailServiceImpl(RestTemplate restTemplate, CardDetailRepositoryService cardDetailRepositoryService) {
        this.restTemplate = restTemplate;
        this.cardDetailRepositoryService = cardDetailRepositoryService;
    }

    /**
     * Given card number get details of the card if it exists in DB
     * Else make a call to BIN LIST API provider and get the details of the card
     * Save the card in the DB to reduce 3rd party API Calls
     */
    @Override
    public GetCardResponse getCardDetails(String cardNumber) throws CardServiceException {
        Card card;

        if (cardExists(cardNumber)) {
            card = cardDetailRepositoryService.getCardDetails(cardNumber);

            GetCardResponse getCardResponse = new GetCardResponse(true, card);
            log.info("---------------------------------------------");
            log.info("Response {} from repository service", getCardResponse);
            return getCardResponse;
        }

        String url = buildUrl(cardNumber);
        try {
            card = restTemplate.getForObject(url, Card.class);
            log.info("---------------------------------------------");
            log.info("Response {} from 3rd Party API", card);
        }
        catch (Exception e) {
            return new GetCardResponse(false, null);
//            throw new CardServiceException("Error occurred while requesting response from API -> Not a valid Card", e.getCause());
        }
        if(card!=null) {
            saveCard(card, cardNumber);
            return new GetCardResponse(true, card);
        }

        return null;
    }

    public Boolean cardExists(String cardNumber) {
        return cardDetailRepositoryService.cardExists(cardNumber);
    }

    public void saveCard(Card card, String cardNumber) {
        cardDetailRepositoryService.saveCard(card, cardNumber);
    }

    protected String buildUrl(String cardNumber) {
        String url = URL_TEMPLATE.replace("$CARD_NUMBER", cardNumber);
        return url;
    }



}
