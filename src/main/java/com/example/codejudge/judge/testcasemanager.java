package com.example.codejudge.judge;

import java.util.ArrayList;
import java.util.List;

public class testcasemanager {

    public List<testcase> getTests(String problemType) {
        if ("A_PLUS_B".equals(problemType)) {
            return getABTests();
        }

        if ("MAX_VALUE".equals(problemType)) {
            return getMaxValueTests();
        }

        return new ArrayList<>();
    }

    private List<testcase> getABTests() {
        List<testcase> tests = new ArrayList<>();

        tests.add(new testcase("1 2", "3"));
        tests.add(new testcase("5 7", "12"));
        tests.add(new testcase("-1 5", "4"));
        tests.add(new testcase("10 20", "30"));
        tests.add(new testcase("100 200", "300"));
        tests.add(new testcase("0 0", "0"));
        tests.add(new testcase("-5 -5", "-10"));
        tests.add(new testcase("999 1", "1000"));
        tests.add(new testcase("214748364 1", "214748365"));
        tests.add(new testcase("1000000 2000000", "3000000"));

        return tests;
    }

    private List<testcase> getMaxValueTests() {
        List<testcase> tests = new ArrayList<>();

        tests.add(new testcase("3\n1 2 3", "3"));
        tests.add(new testcase("5\n10 20 30 40 50", "50"));
        tests.add(new testcase("4\n-1 -5 -3 -2", "-1"));
        tests.add(new testcase("1\n100", "100"));
        tests.add(new testcase("6\n3 9 2 8 1 7", "9"));
        tests.add(new testcase("5\n0 0 0 0 0", "0"));
        tests.add(new testcase("5\n-10 0 10 20 -5", "20"));

        return tests;
    }
}