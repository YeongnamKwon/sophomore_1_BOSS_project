package com.example.codejudge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.example.codejudge.judge.judgemodel;

@Controller
public class SubmitController {

    @GetMapping("/")
    public String submitPage() {
        return "submit";
    }

    @GetMapping("/submit-stream")
    public SseEmitter submitStream(String code) {
        SseEmitter emitter = new SseEmitter(0L);

        new Thread(() -> {
            try {
                judgemodel judgeModel = new judgemodel();

                judgeModel.judgeCodeLive(code, message -> {
                    try {
                        emitter.send(message);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

                emitter.complete();

            } catch (Exception e) {
                try {
                    emitter.send("채점 중 오류 발생: " + e.getMessage());
                } catch (Exception ignored) {
                }

                emitter.completeWithError(e);
            }
        }).start();

        return emitter;
    }
}