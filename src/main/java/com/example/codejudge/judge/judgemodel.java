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

    public void judgeCodeLive(String userCode, String problemType, Consumer<String> send){ 
        try {
            try {
                Files.deleteIfExists(Paths.get("Main.java"));
                Files.deleteIfExists(Paths.get("Main.class"));
                Files.write(
                    Paths.get("Main.java"),
                    userCode.getBytes(StandardCharsets.UTF_8)
                );
            } 
            catch (IOException e) {
                send.accept("사용자 코드 저장 실패: " + e.getMessage());
                return;
            }

            compiler com = new compiler();
            boolean success = com.compile();

            if (!success) {
                send.accept("컴파일 실패");

                if (com.errorMessage != null && !com.errorMessage.isEmpty()) {
                    send.accept(com.errorMessage);
                }

                return;
            }

            testcasemanager manager = new testcasemanager();
            List<testcase> tests = manager.getTests(problemType);

            send.accept("문제 타입: " + problemType);

            if (tests == null || tests.isEmpty()) {
                send.accept("테스트케이스가 없습니다.");
                send.accept("[STATUS]채점 실패");
                return;
            }

            runner run = new runner();
            judge j = new judge();

            long totalRunningTime = 0;
            long maxMemory = 0;

            send.accept("[PROGRESS]0");

            for (int i = 0; i < tests.size(); i++) {
                testcase tc = tests.get(i);
                int count = i + 1;


                errormanager runResult = run.run(tc.input);

                totalRunningTime += runResult.runningTime;
                maxMemory = Math.max(maxMemory, runResult.memory);

                if (runResult.timeout) {
                    send.accept("\n");
                    send.accept("Testcase " + count + ": 시간 초과");
                    send.accept("[STATUS]시간 초과");
                    return;
                }

                if (runResult.runtimeError) {
                    send.accept("\n");
                    send.accept("Testcase " + count + ": 런타임 에러");

                    if (runResult.errorMessage != null) {
                        send.accept(runResult.errorMessage);
                    }

                    send.accept("[STATUS]런타임 에러");
                    return;
                }

                boolean judgeResult = j.check(runResult.output, tc.answer);

                if (!judgeResult) {
                    send.accept("\n");
                    send.accept("오답입니다.");
                    send.accept("입력값: " + tc.input);
                    send.accept("기댓값: " + tc.answer);
                    send.accept("출력값: " + runResult.output);
                    send.accept("[STATUS]틀렸습니다.");
                    return;
                }

                int progress = (int) (((double) count / tests.size()) * 100);
                send.accept("[PROGRESS]" + progress);
            }

            send.accept("\n");
            send.accept("[PROGRESS]100");
            send.accept("[TIME]" + String.format("%.6f s", totalRunningTime / 1000000000.0));
            send.accept("[MEMORY]" + String.format("%.2f MB", maxMemory / 1024.0 / 1024.0));
            send.accept("[LANGUAGE]Java");
            send.accept("[STATUS]정답입니다!!");

        } catch (RuntimeException e) {
            log.severe(String.format("Error : %s%nLocation : %s", e, e.getStackTrace()[0]));
            send.accept("채점 중 오류 발생: " + e.getMessage());
        }
    }
}