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

        if ("PRIME_COUNT".equals(problemType)) {
            return getPrimeCountTests();
        }

        return new ArrayList<>();
    }

    private List<testcase> getABTests() {
        List<testcase> tests = new ArrayList<>();

        // 기본 양수
        tests.add(new testcase("1 2", "3"));
        tests.add(new testcase("5 7", "12"));
        tests.add(new testcase("10 20", "30"));

        // 0 포함
        tests.add(new testcase("0 0", "0"));
        tests.add(new testcase("0 5", "5"));
        tests.add(new testcase("7 0", "7"));

        // 음수 포함
        tests.add(new testcase("-1 5", "4"));
        tests.add(new testcase("5 -3", "2"));
        tests.add(new testcase("-5 -5", "-10"));

        // 큰 수
        tests.add(new testcase("100 200", "300"));
        tests.add(new testcase("999 1", "1000"));
        tests.add(new testcase("1000000 2000000", "3000000"));
        
        return tests;
    }

    private List<testcase> getMaxValueTests() {
        List<testcase> tests = new ArrayList<>();

        // 기본 양수 케이스
        tests.add(new testcase("5\n1 2 3 4 5", "5"));
        tests.add(new testcase("5\n10 30 20 50 40", "50"));
        tests.add(new testcase("6\n3 9 2 8 1 7", "9"));

        // 최댓값 위치 확인
        tests.add(new testcase("5\n100 1 2 3 4", "100"));      // 맨 앞
        tests.add(new testcase("5\n1 2 100 3 4", "100"));      // 중간
        tests.add(new testcase("5\n1 2 3 4 100", "100"));      // 맨 뒤

        // 음수 케이스
        tests.add(new testcase("4\n-1 -5 -3 -2", "-1"));
        tests.add(new testcase("5\n-10 -20 -30 -40 -50", "-10"));
        tests.add(new testcase("5\n-100 -1 -50 -3 -20", "-1"));

        // 0 포함
        tests.add(new testcase("5\n0 0 0 0 0", "0"));
        tests.add(new testcase("5\n-10 0 -5 -3 -1", "0"));
        tests.add(new testcase("6\n-5 10 0 3 -2 8", "10"));

        // 중복 최댓값
        tests.add(new testcase("6\n1 5 3 5 2 5", "5"));
        tests.add(new testcase("5\n100 100 99 98 100", "100"));

        // 원소 1개
        tests.add(new testcase("1\n7", "7"));
        tests.add(new testcase("1\n-99", "-99"));

        // 전부 같은 값
        tests.add(new testcase("5\n3 3 3 3 3", "3"));
        tests.add(new testcase("4\n-8 -8 -8 -8", "-8"));

        // 큰 수
        tests.add(new testcase("5\n1000000 999999 123456 777777 888888", "1000000"));
        tests.add(new testcase("5\n-1000000 -999999 -123456 -777777 -888888", "-123456"));

        return tests;
    }

    private List<testcase> getPrimeCountTests() {
        List<testcase> tests = new ArrayList<>();

        // 기본 예제
        tests.add(new testcase("4\n1 3 5 7", "3"));
        tests.add(new testcase("5\n2 3 4 5 6", "3"));

        // 1은 소수가 아님
        tests.add(new testcase("1\n1", "0"));
        tests.add(new testcase("5\n1 1 1 1 1", "0"));
        tests.add(new testcase("5\n1 2 3 4 5", "3"));

        // 2는 소수
        tests.add(new testcase("1\n2", "1"));
        tests.add(new testcase("5\n2 2 2 2 2", "5"));

        // 소수 없음
        tests.add(new testcase("5\n4 6 8 9 10", "0"));
        tests.add(new testcase("6\n12 14 15 16 18 20", "0"));

        // 전부 소수
        tests.add(new testcase("5\n2 3 5 7 11", "5"));
        tests.add(new testcase("6\n13 17 19 23 29 31", "6"));

        // 소수와 합성수 섞임
        tests.add(new testcase("10\n1 2 3 4 5 6 7 8 9 10", "4"));
        tests.add(new testcase("8\n11 12 13 14 15 16 17 18", "3"));
        tests.add(new testcase("10\n21 22 23 24 25 26 27 28 29 30", "2"));

        // 제곱수는 소수가 아님
        tests.add(new testcase("5\n4 9 16 25 49", "0"));
        tests.add(new testcase("6\n2 4 9 11 25 29", "3"));

        // 큰 수 포함
        tests.add(new testcase("5\n97 98 99 100 101", "2"));
        tests.add(new testcase("5\n997 998 999 1000 991", "2"));

        // 원소 1개
        tests.add(new testcase("1\n17", "1"));
        tests.add(new testcase("1\n100", "0"));

        return tests;
    }
}