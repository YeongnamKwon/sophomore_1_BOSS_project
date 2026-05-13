package Codejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class compiler {

    public boolean compile() {

        try {

            ProcessBuilder pb = new ProcessBuilder("javac","Users_answercode.java");

            Process process = pb.start();
            
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String line;

            while((line = errorReader.readLine()) != null) {

                System.out.println(line);
            }

            int result = process.waitFor();

            return result == 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
}
