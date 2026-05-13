package Codejudge;

import User_answer.Users_answercode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

public class judgemodel {
	static Logger log = Logger.getLogger("Judge");
	
    public static void main(String[] args) {

        try {

        	Users_answercode user = new Users_answercode();

            Files.write( Paths.get("Users_answercode.java"), user.User_code.getBytes());
            
            compiler com = new compiler();
            boolean success = com.compile();

            if(success) {	
            	System.out.println("컴파일 성공");
            	testcasemanager manager = new testcasemanager();
                List<testcase> tests = manager.getTests();
                
            	runner run = new runner();
                judge j = new judge();
                
                int count = 0;

                for(testcase tc : tests) {
                	errormanager runResult = run.run(tc.input);
                    if(runResult.runtimeError) {
                        System.out.println("Run Time Error.");
                        break;
                    }

                	boolean judgeResult = j.check(runResult.output, tc.answer);
                	if(judgeResult) {
                    	System.out.println("Testcase " + ++count + ": 정답");
                        System.out.printf("실행 시간 : %.6f s\n\n", runResult.runningTime / 1000000000.0);
                    } 
                	else {
                    	System.out.println("오답입니다.");
                    	System.out.println("시스템 정답 : " + tc.answer);
                    	System.out.println("실행 결과 : " + runResult.output);
                    	break;
                    }
                }
                if(count == tests.size()) {
                	System.out.println("정답입니다!");
                }
                
            }
            else {
            	System.out.println("컴파일 실패");
            	return;
            }
        } 
        catch (Exception e) {
        	log.severe(e.getMessage());
        	e.printStackTrace();
        }
    }
}