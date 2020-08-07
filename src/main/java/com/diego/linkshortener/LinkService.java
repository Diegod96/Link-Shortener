package com.diego.linkshortener;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class LinkService {

    private final String baseUrl;

    Mono<String> shortenLink(String link) {
        String randomKey = RandomStringUtils.randomAlphabetic(6);
        //save to DB
        return Mono.just(baseUrl + randomKey);
    }

    public LinkService(@Value("$app.baseUrl}") String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
