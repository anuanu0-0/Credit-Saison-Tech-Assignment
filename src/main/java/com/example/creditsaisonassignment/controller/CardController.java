package com.example.creditsaisonassignment.controller;

import com.example.creditsaisonassignment.exceptions.CardServiceException;
import com.example.creditsaisonassignment.exchanges.GetCardNumberRequest;
import com.example.creditsaisonassignment.exchanges.GetCardResponse;
import com.example.creditsaisonassignment.exchanges.GetCardStatsResponse;
import com.example.creditsaisonassignment.services.CardDetailService;
import com.example.creditsaisonassignment.services.CardStatsService;
import com.example.creditsaisonassignment.services.CardStatsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CardController.BIN_API_ENDPOINT)
public class CardController {

    public static final String BIN_API_ENDPOINT = "/card-scheme";
    public static final String BIN_VERIFY_API = "/verify";
    public static final String BIN_STATS_API = "/stats";

    public static final String BIN_CARD_NUM_API = "/{cardNumber}";

    private final CardDetailService cardDetailService;
    private final CardStatsService cardStatsService;

    private static final Logger log = LoggerFactory.getLogger(CardController.class);


    @Autowired
    public CardController(CardDetailService cardDetailService, CardStatsService cardStatsService) {
        this.cardDetailService = cardDetailService;
        this.cardStatsService = cardStatsService;
    }

    /**
     * Check whether the given card is valid or not and for valid cards get the payload response.
     * @param getCardNumber valid card number
     * @return GetCardResponse object containing a payload object consisting of scheme, type and bank name.
     * **/

    @GetMapping(BIN_VERIFY_API + BIN_CARD_NUM_API)
    public ResponseEntity<GetCardResponse> getCardDetails(GetCardNumberRequest getCardNumber) throws CardServiceException {
        String cardNumber = getCardNumber.getCardNumber();
        cardStatsService.saveCardStats(cardNumber);
        GetCardResponse getCardResponse = cardDetailService.getCardDetails(cardNumber);
//        if(getCardResponse == null) {
//            log.info("----------------------------------------");
//            log.info("Bad request - 400");
//            getCardResponse.setSuccess(false);
//            getCardResponse.setCard(null);
//        } else {
//            getCardResponse.setSuccess(true);
//        }
        return new ResponseEntity( getCardResponse, HttpStatus.OK);
    }

    /**
     * Get the list of all the unique bins and their respective stats.
     * @return GetCardStatsResponse object containing a list of CardStats objects
     * **/
    @GetMapping(BIN_STATS_API)
    public ResponseEntity<GetCardStatsResponse> getCardStats() {
        log.info("--------------------------------------------");
        log.info(" Get Bin Statistics");
        GetCardStatsResponse getCardStatsResponse = cardStatsService.getStatistics();
        return new ResponseEntity(getCardStatsResponse, HttpStatus.OK);
    }
}
