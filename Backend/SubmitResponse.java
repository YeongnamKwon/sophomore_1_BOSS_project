package Backend;

public class SubmitResponse {
    private String result; // 채점 결과
    private String output; // 실행 후 출력값
    private String errorMessage; // 실행 중 오류 발생 메시지

    public SubmitResponse() { // 기본 생성자
    }

    //필드 초기화
    public SubmitResponse(String result, String output, String errorMessage) {
        this.result = result;
        this.output = output;
        this.errorMessage = errorMessage;
    }

    public String getResult() { // 결과 값 반환
        return result;
    }

    public void setResult(String result) { // 결과 값 저장
        this.result = result;
    }

    public String getOutput() { // 출력 값 반환
        return output;
    }

    public void setOutput(String output) { // 출력 값 저장
        this.output = output;
    }

    public String getErrorMessage() { // 오류 메시지 값 반환
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) { // 오류 메시지 값 저장
        this.errorMessage = errorMessage;
    }
}