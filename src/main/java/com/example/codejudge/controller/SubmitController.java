package com.example.codejudge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.example.codejudge.judge.judgemodel;

import jakarta.servlet.http.HttpSession;

@Controller
public class SubmitController {

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/submit")
    public String submitPage(HttpSession session, Model model) {
        String userId = (String) session.getAttribute("userId");

        if (userId == null || userId.isBlank()) {
            return "redirect:/login";
        }

        model.addAttribute("userId", userId);

        return "submit";
    }

    @GetMapping("/submit-stream")
    public SseEmitter submitStream(String code, HttpSession session) {
        SseEmitter emitter = new SseEmitter(0L);

        String userId = (String) session.getAttribute("userId");

        if (userId == null || userId.isBlank()) {
            try {
                emitter.send("로그인 정보가 없습니다. 다시 로그인해주세요.");
                emitter.complete();
            } catch (Exception e) {
                emitter.completeWithError(e);
            }

            return emitter;
        }

        new Thread(() -> {
            try {
                judgemodel judgeModel = new judgemodel();
                emitter.send("[학번 " + userId + "] ");
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