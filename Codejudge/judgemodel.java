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

            Files.write( Paths.get("Main.java"),user.User_code.getBytes());

            System.out.println("파일 생성 완료");

        } catch (Exception e) {
        	log.severe(e.getMessage());
        	e.printStackTrace();
        }
    }
}