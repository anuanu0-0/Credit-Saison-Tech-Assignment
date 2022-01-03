package com.example.creditsaisonassignment.exchanges;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class GetCardNumberRequest {
    @NotNull(message = "Card Number cannot be null")
    private String cardNumber;
}
