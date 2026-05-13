package Backend;

import java.util.ArrayList;
import java.util.List;

public class TestCaseManager {

    public List<TestCase> getTests() {
        List<TestCase> tests = new ArrayList<>();

        tests.add(new TestCase("1 2", "3"));
        tests.add(new TestCase("5 7", "12"));
        tests.add(new TestCase("-1 5", "4"));
        tests.add(new TestCase("10 20", "30"));
tests.add(new TestCase("100 200", "300"));
tests.add(new TestCase("0 0", "0"));
tests.add(new TestCase("3 9", "12"));
tests.add(new TestCase("8 1", "9"));
tests.add(new TestCase("15 15", "30"));
tests.add(new TestCase("99 1", "100"));
tests.add(new TestCase("-5 -5", "-10"));
tests.add(new TestCase("-10 20", "10"));
tests.add(new TestCase("50 -25", "25"));
tests.add(new TestCase("-100 50", "-50"));
tests.add(new TestCase("7 -3", "4"));
tests.add(new TestCase("-7 3", "-4"));
tests.add(new TestCase("123 456", "579"));
tests.add(new TestCase("111 222", "333"));
tests.add(new TestCase("999 1", "1000"));
tests.add(new TestCase("500 500", "1000"));

tests.add(new TestCase("2 3", "5"));
tests.add(new TestCase("4 6", "10"));
tests.add(new TestCase("12 34", "46"));
tests.add(new TestCase("25 75", "100"));
tests.add(new TestCase("60 40", "100"));
tests.add(new TestCase("-2 -8", "-10"));
tests.add(new TestCase("-15 5", "-10"));
tests.add(new TestCase("-30 -70", "-100"));
tests.add(new TestCase("1000 2000", "3000"));
tests.add(new TestCase("1234 -234", "1000"));

tests.add(new TestCase("17 28", "45"));
tests.add(new TestCase("33 44", "77"));
tests.add(new TestCase("56 78", "134"));
tests.add(new TestCase("90 10", "100"));
tests.add(new TestCase("101 202", "303"));
tests.add(new TestCase("-11 1", "-10"));
tests.add(new TestCase("-22 2", "-20"));
tests.add(new TestCase("-33 3", "-30"));
tests.add(new TestCase("-44 4", "-40"));
tests.add(new TestCase("-55 5", "-50"));

tests.add(new TestCase("7 7", "14"));
tests.add(new TestCase("14 14", "28"));
tests.add(new TestCase("21 21", "42"));
tests.add(new TestCase("28 28", "56"));
tests.add(new TestCase("35 35", "70"));
tests.add(new TestCase("42 42", "84"));
tests.add(new TestCase("49 49", "98"));
tests.add(new TestCase("56 56", "112"));
tests.add(new TestCase("63 63", "126"));
tests.add(new TestCase("70 70", "140"));

tests.add(new TestCase("81 19", "100"));
tests.add(new TestCase("72 28", "100"));
tests.add(new TestCase("63 37", "100"));
tests.add(new TestCase("54 46", "100"));
tests.add(new TestCase("45 55", "100"));
tests.add(new TestCase("36 64", "100"));
tests.add(new TestCase("27 73", "100"));
tests.add(new TestCase("18 82", "100"));
tests.add(new TestCase("9 91", "100"));
tests.add(new TestCase("100 0", "100"));

tests.add(new TestCase("-1 -1", "-2"));
tests.add(new TestCase("-2 -2", "-4"));
tests.add(new TestCase("-3 -3", "-6"));
tests.add(new TestCase("-4 -4", "-8"));
tests.add(new TestCase("-5 -6", "-11"));
tests.add(new TestCase("-7 -8", "-15"));
tests.add(new TestCase("-9 -10", "-19"));
tests.add(new TestCase("-11 -12", "-23"));
tests.add(new TestCase("-13 -14", "-27"));
tests.add(new TestCase("-15 -16", "-31"));

tests.add(new TestCase("250 250", "500"));
tests.add(new TestCase("300 700", "1000"));
tests.add(new TestCase("123 877", "1000"));
tests.add(new TestCase("444 556", "1000"));
tests.add(new TestCase("321 123", "444"));
tests.add(new TestCase("999 999", "1998"));
tests.add(new TestCase("100 900", "1000"));
tests.add(new TestCase("808 192", "1000"));
tests.add(new TestCase("654 346", "1000"));
tests.add(new TestCase("111 889", "1000"));

tests.add(new TestCase("10000 1", "10001"));
tests.add(new TestCase("9999 1", "10000"));
tests.add(new TestCase("5000 5000", "10000"));
tests.add(new TestCase("12345 54321", "66666"));
tests.add(new TestCase("-1000 1000", "0"));
tests.add(new TestCase("-999 999", "0"));
tests.add(new TestCase("-500 250", "-250"));
tests.add(new TestCase("-1234 -4321", "-5555"));
tests.add(new TestCase("777 -777", "0"));
tests.add(new TestCase("314 686", "1000"));

tests.add(new TestCase("88 12", "100"));
tests.add(new TestCase("76 24", "100"));
tests.add(new TestCase("64 36", "100"));
tests.add(new TestCase("52 48", "100"));
tests.add(new TestCase("39 61", "100"));
tests.add(new TestCase("26 74", "100"));
tests.add(new TestCase("13 87", "100"));
tests.add(new TestCase("222 333", "555"));
tests.add(new TestCase("345 655", "1000"));
tests.add(new TestCase("432 568", "1000"));
tests.add(new TestCase("10 20", "31"));

        return tests;
    }
}