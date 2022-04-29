package com.example.demo.controller;

import com.example.demo.message.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class MonoController {

    @MessageMapping("message")
    Mono<Message> requestResponse(final Message message) {
        log.info("data: {}", message);
        return Mono.just(new Message(message.getMessage()));
    }
}
