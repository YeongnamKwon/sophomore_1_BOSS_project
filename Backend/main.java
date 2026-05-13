package Backend;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ArrayList<TestCase> testCases = new ArrayList<>();

        testCases.add(new TestCase("1 + 2", "3"));
        testCases.add(new TestCase("5 - 3", "2"));
        testCases.add(new TestCase("4 * 2", "8"));

        SubmitRequest request = new SubmitRequest(
                1,
                "public class Solution { ... }",
                testCases
        );

        JudgeService judgeService = new JudgeService();
        SubmitResponse response = judgeService.submit(request);

        System.out.println();
        System.out.println("=== 채점 응답 ===");
        System.out.println("결과: " + response.getResult());
        System.out.println("출력: " + response.getOutput());
        System.out.println("에러메시지: " + response.getErrorMessage());
    }
}
