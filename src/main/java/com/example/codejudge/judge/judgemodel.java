package com.example.codejudge.judge;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class judgemodel {
    static final Logger log = Logger.getLogger("Judge");

    public void judgeCodeLive(String userCode, Consumer<String> send) {
        try {
            send.accept("사용자 코드 저장 중...");

            try {
                Files.write(
                    Paths.get("Users_answercode.java"),
                    userCode.getBytes(StandardCharsets.UTF_8)
                );
            } 
            catch (IOException e) {
                send.accept("사용자 코드 저장 실패: " + e.getMessage());
                return;
            }

            send.accept("컴파일 중...");

            compiler com = new compiler();
            boolean success = com.compile();

            if (!success) {
                send.accept("컴파일 실패");

                if (com.errorMessage != null && !com.errorMessage.isEmpty()) {
                    send.accept(com.errorMessage);
                }

                return;
            }

            send.accept("컴파일 성공");
            send.accept("=============================");

            testcasemanager manager = new testcasemanager();
            List<testcase> tests = manager.getTests();

            runner run = new runner();
            judge j = new judge();

            int count = 0;

            for (testcase tc : tests) {
                count++;
                errormanager runResult = run.run(tc.input);

                if (runResult.timeout) {
                    send.accept("Testcase " + count + ": 시간 초과");
                    break;
                }

                if (runResult.runtimeError) {
                    send.accept("Testcase " + count + ": 런타임 에러");

                    if (runResult.errorMessage != null) {
                        send.accept(runResult.errorMessage);
                    }

                    break;
                }

                boolean judgeResult = j.check(runResult.output, tc.answer);

                if (judgeResult) {
                    send.accept("Testcase " + count + ": 정답");
                    send.accept("메모리 사용량: " + String.format("%.2f MB", runResult.memory / 1024.0 / 1024.0));
                    send.accept("실행 시간: " + String.format("%.6f s", runResult.runningTime / 1000000000.0));
                    send.accept("=============================");
                } else {
                    send.accept("Testcase " + count + ": 오답");
                    send.accept("입력값: " + tc.input);
                    send.accept("시스템 정답: " + tc.answer);
                    send.accept("실행 결과: " + runResult.output);
                    send.accept("=============================");
                    break;
                }
            }

            if (count == tests.size()) {
                send.accept("정답입니다!");
            }

        } catch (RuntimeException e) {
            log.severe(String.format("Error : %s%nLocation : %s", e, e.getStackTrace()[0]));
            send.accept("채점 중 오류 발생: " + e.getMessage());
        }
    }
}