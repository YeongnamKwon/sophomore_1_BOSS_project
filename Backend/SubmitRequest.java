package Backend;

public class SubmitRequest {
    private String sourceCode;

    public SubmitRequest(String sourceCode){
        this.sourceCode = sourceCode;
    }

    public String getSourceCode(){
        return sourceCode;
    }
}
