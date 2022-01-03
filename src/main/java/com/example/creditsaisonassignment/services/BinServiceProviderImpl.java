package com.example.creditsaisonassignment.services;

import com.example.creditsaisonassignment.dto_dummy.Bin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BinServiceProviderImpl implements BinServiceProvider{
    private final String URL_TEMPLATE = "https://lookup.binlist.net/$CARDNUMBER";
    private static final Logger log = LoggerFactory.getLogger(BinServiceProviderImpl.class);
    private final RestTemplate restTemplate;

    public BinServiceProviderImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    protected String buildUrl(String cardNumber) {
        String url = URL_TEMPLATE.replace("$CARDNUMBER", cardNumber);
        return url;
    }


    @Override
    public Bin getBinService(String cardNumber) {
        String url = buildUrl(cardNumber);
        return restTemplate.getForObject(url, Bin.class);
    }
}
