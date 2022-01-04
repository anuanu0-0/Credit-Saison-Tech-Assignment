package com.example.creditsaisonassignment.services;

public interface BinStats {
    String registerNewBin(String cardNumber);
    Integer getHitCount(String cardNumber);

}
