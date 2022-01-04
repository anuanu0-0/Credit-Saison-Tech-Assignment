package com.example.creditsaisonassignment.exchanges;

import com.example.creditsaisonassignment.dto.Card;
import com.example.creditsaisonassignment.dto_dummy.Bank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GetCardResponse {
    Card card;
}
