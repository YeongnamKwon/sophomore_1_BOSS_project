package Codejudge;

import java.util.ArrayList;
import java.util.List;

public class testcasemanager {

    public List<testcase> getTests() {
    	List<testcase> tests =  new ArrayList<>();

        tests.add(new testcase("1 2","3"));
        
        tests.add(new testcase("5 7","12"));
        
        tests.add(new testcase( "-1 5","4"));

        return tests;
    }
}