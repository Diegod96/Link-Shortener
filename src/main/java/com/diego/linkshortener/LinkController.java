package com.diego.linkshortener;


import jdk.dynalink.linker.LinkerServices;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class LinkController {

    private final LinkService linkService;

    @PostMapping("/link")
    Mono<CreateLinkResponse> create(@RequestBody CreateLinkRequest request) {
        return linkService.shortenLink(request.getLink())
                .map(CreateLinkResponse::new);
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
