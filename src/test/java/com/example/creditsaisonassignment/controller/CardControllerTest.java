package com.example.creditsaisonassignment.controller;

import com.example.creditsaisonassignment.dto.Bank;
import com.example.creditsaisonassignment.dto.Card;
import com.example.creditsaisonassignment.exceptions.CardServiceException;
import com.example.creditsaisonassignment.exchanges.GetCardNumberRequest;
import com.example.creditsaisonassignment.exchanges.GetCardResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@DisplayName("CardControllerTest")
@ExtendWith(MockitoExtension.class)
public class CardControllerTest {

    @Autowired
    private CardController cardController;

    @Test
    @DisplayName("Given valid card number return card details")
    public void givenValidCardNumber_returnCardDetails() throws CardServiceException {
        // Arrange
        GetCardNumberRequest getCardNumberRequest = new GetCardNumberRequest();
        getCardNumberRequest.setCardNumber("45717360");
        GetCardResponse getCardResponse = cardController.getCardDetails(getCardNumberRequest).getBody();
        Card expectedCard = getCardResponse.getCard();

        // Act
        Card actualCard = new Card();
        actualCard.setScheme("visa");
        Bank bank = new Bank();
        bank.setName("Jyske Bank");
        actualCard.setBank(bank);
        actualCard.setType("debit");

        // Assert
        Assertions.assertEquals(expectedCard, actualCard);
    }
}
