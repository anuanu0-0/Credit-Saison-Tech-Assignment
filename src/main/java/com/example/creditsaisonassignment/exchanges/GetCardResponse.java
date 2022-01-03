package com.example.creditsaisonassignment.exchanges;

import com.example.creditsaisonassignment.dto_dummy.Bank;
import lombok.Data;

@Data
public class GetCardResponse {
    private String scheme;
    private String type;
    private Bank bank;
}
