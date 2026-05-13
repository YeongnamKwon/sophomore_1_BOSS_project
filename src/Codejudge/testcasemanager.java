package Codejudge;

import java.util.ArrayList;
import java.util.List;

public class testcasemanager {

    public List<testcase> getTests() {
    	List<testcase> tests =  new ArrayList<>();

        tests.add(new testcase("1 2","3"));
tests.add(new testcase("5 7","12"));
tests.add(new testcase("-1 5","4"));
tests.add(new testcase("10 20","30"));
tests.add(new testcase("100 200","300"));
tests.add(new testcase("0 0","0"));
tests.add(new testcase("3 9","12"));
tests.add(new testcase("8 1","9"));
tests.add(new testcase("15 15","30"));
tests.add(new testcase("99 1","100"));

tests.add(new testcase("-5 -5","-10"));
tests.add(new testcase("-10 20","10"));
tests.add(new testcase("50 -25","25"));
tests.add(new testcase("-100 50","-50"));
tests.add(new testcase("7 -3","4"));
tests.add(new testcase("-7 3","-4"));
tests.add(new testcase("123 456","579"));
tests.add(new testcase("111 222","333"));
tests.add(new testcase("999 1","1000"));
tests.add(new testcase("500 500","1000"));

tests.add(new testcase("12 34","46"));
tests.add(new testcase("56 78","134"));
tests.add(new testcase("90 10","100"));
tests.add(new testcase("25 75","100"));
tests.add(new testcase("33 67","100"));
tests.add(new testcase("44 56","100"));
tests.add(new testcase("1 99","100"));
tests.add(new testcase("2 98","100"));
tests.add(new testcase("49 51","100"));
tests.add(new testcase("60 40","100"));

tests.add(new testcase("1234 4321","5555"));
tests.add(new testcase("2222 3333","5555"));
tests.add(new testcase("1000 9000","10000"));
tests.add(new testcase("555 445","1000"));
tests.add(new testcase("876 124","1000"));
tests.add(new testcase("314 686","1000"));
tests.add(new testcase("777 223","1000"));
tests.add(new testcase("9999 1","10000"));
tests.add(new testcase("2500 2500","5000"));
tests.add(new testcase("1357 2468","3825"));

tests.add(new testcase("-50 -50","-100"));
tests.add(new testcase("-25 100","75"));
tests.add(new testcase("100 -25","75"));
tests.add(new testcase("-500 1000","500"));
tests.add(new testcase("1000 -500","500"));
tests.add(new testcase("-999 999","0"));
tests.add(new testcase("999 -999","0"));
tests.add(new testcase("-1000 -1000","-2000"));
tests.add(new testcase("123 -23","100"));
tests.add(new testcase("-123 23","-100"));

tests.add(new testcase("11 22","33"));
tests.add(new testcase("22 33","55"));
tests.add(new testcase("33 44","77"));
tests.add(new testcase("44 55","99"));
tests.add(new testcase("55 66","121"));
tests.add(new testcase("66 77","143"));
tests.add(new testcase("77 88","165"));
tests.add(new testcase("88 99","187"));
tests.add(new testcase("99 111","210"));
tests.add(new testcase("101 202","303"));

tests.add(new testcase("13 17","30"));
tests.add(new testcase("19 21","40"));
tests.add(new testcase("23 27","50"));
tests.add(new testcase("29 31","60"));
tests.add(new testcase("37 33","70"));
tests.add(new testcase("41 39","80"));
tests.add(new testcase("45 45","90"));
tests.add(new testcase("50 50","100"));
tests.add(new testcase("60 60","120"));
tests.add(new testcase("70 70","140"));

tests.add(new testcase("81 19","100"));
tests.add(new testcase("91 9","100"));
tests.add(new testcase("73 27","100"));
tests.add(new testcase("64 36","100"));
tests.add(new testcase("58 42","100"));
tests.add(new testcase("47 53","100"));
tests.add(new testcase("39 61","100"));
tests.add(new testcase("28 72","100"));
tests.add(new testcase("16 84","100"));
tests.add(new testcase("5 95","100"));

tests.add(new testcase("1001 999","2000"));
tests.add(new testcase("1500 500","2000"));
tests.add(new testcase("1750 250","2000"));
tests.add(new testcase("1234 766","2000"));
tests.add(new testcase("1999 1","2000"));
tests.add(new testcase("250 750","1000"));
tests.add(new testcase("333 667","1000"));
tests.add(new testcase("444 556","1000"));
tests.add(new testcase("888 112","1000"));
tests.add(new testcase("321 679","1000"));

tests.add(new testcase("-1 -1","-2"));
tests.add(new testcase("-2 -3","-5"));
tests.add(new testcase("-4 -6","-10"));
tests.add(new testcase("-8 -12","-20"));
tests.add(new testcase("-16 -24","-40"));
tests.add(new testcase("-32 -48","-80"));
tests.add(new testcase("-64 -36","-100"));
tests.add(new testcase("-100 0","-100"));
tests.add(new testcase("0 -100","-100"));
tests.add(new testcase("-500 -500","-1000"));

tests.add(new testcase("214748364 1","214748365"));
tests.add(new testcase("1000000 2000000","3000000"));
tests.add(new testcase("999999 1","1000000"));
tests.add(new testcase("123456 654321","777777"));
tests.add(new testcase("111111 888889","1000000"));
tests.add(new testcase("765432 234568","1000000"));
tests.add(new testcase("500000 500000","1000000"));
tests.add(new testcase("13579 86421","100000"));
tests.add(new testcase("24680 75320","100000"));
tests.add(new testcase("99999 1","100000"));

        return tests;
    }
}