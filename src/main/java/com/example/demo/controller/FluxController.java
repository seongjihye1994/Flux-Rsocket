package com.example.demo.controller;

import com.example.demo.message.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@Controller
@Slf4j
public class FluxController {

    /**
     * fire-and-forget
     * request-response - Mono
     * request-stream - Flux
     * channel
     *
     * only support http/tcp
     */
    @MessageMapping("flux")
    Flux<Response> flux(String message) {
        log.info(message);

        var stream = Stream.generate(() -> new Response(message));

        return Flux
                .fromStream(stream)
                .delayElements(Duration.ofSeconds(1));
    }
}
