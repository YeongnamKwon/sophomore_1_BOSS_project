package Backend;

import java.util.List;

public class main {
    public static void main(String[] args) {
        TestCaseManager manager = new TestCaseManager();
        List<TestCase> tests = manager.getTests();

        System.out.println("=== 테스트케이스 목록 ===");

        for (int i = 0; i < tests.size(); i++) {
            TestCase tc = tests.get(i);

            System.out.println("TestCase " + (i + 1));
            System.out.println("입력값: " + tc.getInput());
            System.out.println("정답값: " + tc.getAnswer());
            System.out.println();
        }
    }
}