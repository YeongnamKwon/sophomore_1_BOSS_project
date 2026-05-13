package Backend;

import java.util.List;

public class main {
    public static void main(String[] args) {
        TestCaseManager manager = new TestCaseManager();
        List<TestCase> tests = manager.getTests();

        boolean allPassed = true;

        for (int i = 0; i < tests.size(); i++) {
            long startTime = System.nanoTime();

            TestCase tc = tests.get(i);

            String[] parts = tc.getInput().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);

            String result = String.valueOf(a + b);

            long endTime = System.nanoTime();

            Runtime runtime = Runtime.getRuntime();
            double usedMB = (runtime.totalMemory() - runtime.freeMemory()) / (1024.0 * 1024.0);
            double elapsedSec = (endTime - startTime) / 1_000_000_000.0;

            System.out.println("------------------------------");

            if (result.equals(tc.getAnswer())) {
                System.out.println("Testcase " + (i + 1) + ": 정답");
                System.out.printf("메모리 사용량 : %.2f MB%n", usedMB);
                System.out.printf("실행 시간 : %.6f s%n", elapsedSec);
            } else {
                System.out.println("Testcase " + (i + 1) + ": 오답");
                System.out.println("시스템 정답 : " + tc.getAnswer());
                System.out.println("실행 결과 : " + result);
                allPassed = false;
            }

            System.out.println();
        }

        if (allPassed) {
            System.out.println("정답입니다!");
        } else {
            System.out.println("오답입니다!");
        }
    }
}