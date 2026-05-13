package Backend;

public class JudgeService {

    public SubmitResponse submit(SubmitRequest request) {
        System.out.println("문제 번호: " + request.getProblemld());
        System.out.println("제출 코드: " + request.getSourceCode());
        System.out.println("테스트케이스 개수: " + request.getTestCases().size());

        for (int i = 0; i < request.getTestCases().size(); i++) {
            TestCase tc = request.getTestCases().get(i);
            System.out.println("TestCase " + (i + 1) +
                    " | input = " + tc.getInput() +
                    " | answer = " + tc.getAnswer());
        }

         return new SubmitResponse("성공", "채점 요청이 정상적으로 전달되었습니다.", "");
    }
}