package Codejudge;

import java.nio.file.Files;
import java.nio.file.Paths;
import User_answer.Users_answercode;

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
            	runner run = new runner();

                String output =  run.run();
                
                judge j = new judge();

                boolean result = j.check(output, "3");

                if(result) {
                	System.out.println("정답");
                } 
                else {
                	System.out.println("오답 ");
                	System.out.println("시스템 정답 : " + "3");
                	System.out.println("실행 결과 : " + output);
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
