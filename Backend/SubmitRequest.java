package Backend;

//채점 후 결과 저장
public class SubmitRequest {
    private String sourceCode; // 제출한 소스코드
    private String input; // 입력값
    private String expectedOutput; // 기대 출력값

    public String getSourceCode(){ // s.C값 반환
        return sourceCode;
    }

    public void setSourceCode(String sourceCode){ // s.C값 저장
        this.sourceCode = sourceCode;
    }

    public String getInput(){ // input 값을 반환
        return input;
    }

    public void setInput(String input){ // input 값을 저장
        this.input = input;
    }

    public String getExpectedOutput(){ // e.O 값을 반환
        return expectedOutput;
    }

    public void setExpectedOutput(String expectedOutput){ // e.O 값을 저장
        this.expectedOutput = expectedOutput; 
    }
}

