package Backend;

public class TestCase {
    private String input;
    private String answer;

    public TestCase(String input, String answer) {
        this.input = input;
        this.answer = answer;
    }

    public String getInput() {
        return input;
    }

    public String getAnswer() {
        return answer;
    }
}