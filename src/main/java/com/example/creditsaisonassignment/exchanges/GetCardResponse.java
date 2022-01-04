package com.example.creditsaisonassignment.exchanges;

import com.example.creditsaisonassignment.dto.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GetCardResponse {
    Boolean success;
    Card card;
}
