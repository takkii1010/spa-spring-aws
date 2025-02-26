package com.tiscon11.question.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/qa")
public class QaController {

    @GetMapping
    public List<QaResponse> get() {
        return List.of(
            new QaResponse(1L, "質問１"),
            new QaResponse(2L, "質問２")
        );
    }

    @PostMapping
    public QaResponse post(@RequestBody PostRequest request) {
        return new QaResponse(4L, request.text);
    }

    public static class PostRequest {

        public String text;
    }

    public static class QaResponse {

        public final Long id;

        public final String text;

        public QaResponse(Long id, String text) {
        this.id = id;
        this.text = text;
        }
    }
}