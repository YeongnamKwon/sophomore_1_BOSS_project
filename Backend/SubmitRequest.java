package Backend;

public class SubmitRequest {
    private String sourceCode;
    private String input;
    private String expectedOutput;

    public String getSourceCode(){
        return sourceCode;
    }

    public void setSourceCode(String sourceCode){
        this.sourceCode = sourceCode;
    }

    public String getInput(){
        return input;
    }

    public void setInput(String input){
        this.input = input;
    }

    public String getExpectedOutput(){
        return expectedOutput;
    }

    public void setExpectedOutput(String expectedOutput){
        this.expectedOutput = expectedOutput; 
    }
}

