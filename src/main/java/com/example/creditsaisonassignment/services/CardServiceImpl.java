package com.example.creditsaisonassignment.services;

import com.example.creditsaisonassignment.dto.Card;
import com.example.creditsaisonassignment.exchanges.GetCardResponse;
import com.example.creditsaisonassignment.exchanges.GetCardStatsResponse;
import com.example.creditsaisonassignment.repositoryServices.CardRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CardServiceImpl implements CardService {

    private final String URL_TEMPLATE = "https://lookup.binlist.net/$CARD_NUMBER";
    private static final Logger log = LoggerFactory.getLogger(BinServiceProviderImpl.class);
    private final RestTemplate restTemplate;

    private final CardRepositoryService cardRepositoryService;


    @Autowired
    public CardServiceImpl(RestTemplate restTemplate, CardRepositoryService cardRepositoryService) {
        this.restTemplate = restTemplate;
        this.cardRepositoryService = cardRepositoryService;
    }

    /**
     * Given card number get details of the card if it exists in DB
     * Else make a call to BIN LIST API provider and get the details of the card
     * Save the card in the DB to reduce 3rd party API Calls
     */
    @Override
    public GetCardResponse getCardDetails(String cardNumber) {
        Card card;

        if (cardExists(cardNumber)) {
            card = cardRepositoryService.getCardDetails(cardNumber);

            // TO CHECK : card can be a null object
            GetCardResponse getCardResponse = new GetCardResponse(card);
            log.info("---------------------------------------------");
            log.info("Response {} from repository service", getCardResponse);
            return getCardResponse;
        }

        String url = buildUrl(cardNumber);
        card = restTemplate.getForObject(url, Card.class);
        log.info("---------------------------------------------");
        log.info("Response {} from 3rd Party API", card);
        if(card!=null) {
            saveCard(card, cardNumber);
            return new GetCardResponse(card);
        }

        return null;
    }

    /**
     *
     * */
    @Override
    public GetCardStatsResponse getCardStatsList() {
        return null;
    }

    public Boolean cardExists(String cardNumber) {
        return cardRepositoryService.cardExists(cardNumber);
    }

    public void saveCard(Card card, String cardNumber) {
        cardRepositoryService.saveCard(card, cardNumber);
    }

    protected String buildUrl(String cardNumber) {
        String url = URL_TEMPLATE.replace("$CARD_NUMBER", cardNumber);
        return url;
    }

}
