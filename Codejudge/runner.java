package Codejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class runner {

    public String run() {

        try {
        	ProcessBuilder pb =new ProcessBuilder("java","Users_answercode.java");

            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            writer.write("1 2");
            writer.newLine();

            writer.flush();
            writer.close();
            
            StringBuilder output = new StringBuilder();

            String line;

            while((line = reader.readLine()) != null) {
            	output.append(line);
            }

            process.waitFor();
            
            return output.toString();

        } catch (Exception e) {

            e.printStackTrace();

            return "";
        }
    }
}
