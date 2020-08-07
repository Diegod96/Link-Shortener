package com.diego.linkshortener;


import lombok.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class LinkController {

    @PostMapping("/link")
    Mono<CreateLinkResponse> create(@RequestBody CreateLinkRequest request) {
        return Mono.just(new CreateLinkResponse("http://localhost:8080/aass2211"));
    }

    @Value
    static class CreateLinkRequest {
        private String link;
    }

    @Value
    static class CreateLinkResponse {
        private String shortenedLink;


    }


}
