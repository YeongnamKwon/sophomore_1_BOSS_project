package Backend;

import java.util.ArrayList;

public class SubmitRequest {
    private int problemld;
    private String sourceCode;
    private ArrayList<TestCase> testCases;

    public SubmitRequest(int problemld, String sourceCode, ArrayList<TestCase> testCases){
        this.problemld = problemld;
        this.sourceCode = sourceCode;
        this.testCases = testCases;
        
    }

    public int getProblemld(){
        return problemld;
    }

    public String getSourceCode(){
        return sourceCode;
    }

    public ArrayList<TestCase> getTestCases(){
        return testCases;
    }
}
