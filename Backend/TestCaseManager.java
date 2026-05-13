package Backend;

import java.util.ArrayList;
import java.util.List;

public class TestCaseManager {

    public List<TestCase> getTests() {
        List<TestCase> tests = new ArrayList<>();

        tests.add(new TestCase("1 2", "3"));
        tests.add(new TestCase("5 7", "12"));
        tests.add(new TestCase("-1 5", "4"));

        return tests;
    }
}