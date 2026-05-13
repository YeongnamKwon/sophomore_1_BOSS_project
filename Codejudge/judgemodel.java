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

            Files.write( Paths.get("Users_answercode.java"),user.User_code.getBytes());
            String content = Files.readString(Paths.get("Users_answercode.java"));
            
            System.out.println(content);

        } catch (Exception e) {
        	log.severe(e.getMessage());
        	e.printStackTrace();
        }
    }
}
