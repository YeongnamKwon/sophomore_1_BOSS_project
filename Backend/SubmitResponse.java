package Backend;

public class SubmitResponse {
    private String result;
    private String output;
    private String errorMessage;

    public SubmitResponse(String result, String output, String errorMessage) {
        this.result = result;
        this.output = output;
        this.errorMessage = errorMessage;
    }

    public String getResult() {
        return result;
    }

    public String getOutput() {
        return output;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}