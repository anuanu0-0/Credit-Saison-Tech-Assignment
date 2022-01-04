package com.example.creditsaisonassignment.models;

import com.example.creditsaisonassignment.dto.Bank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
//@Document(collection="card")
public class CardEntity {
    @Id
    private String cardNumber;
    private String scheme;
    private String type;
    private Bank bank;
}
