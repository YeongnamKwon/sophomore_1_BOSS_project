package Codejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class runner {

    public String run(String input) {

        try {
        	ProcessBuilder pb =new ProcessBuilder("java","Users_answercode.java");

            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            BufferedReader errorReader = new BufferedReader( new InputStreamReader(process.getErrorStream()));
            
            writer.write(input);
            writer.newLine();

            writer.flush();
            writer.close();
            
            StringBuilder output = new StringBuilder();
            StringBuilder error = new StringBuilder();

            String line;

            while((line = reader.readLine()) != null) {
            	output.append(line);
            }
            
            while((line = errorReader.readLine()) != null) {
            	error.append(line);
            }

            process.waitFor();
            
            if(error.length() > 0) {
            	return "Runtime Error : " + error;
            }
            
            return output.toString();

        } catch (Exception e) {

            e.printStackTrace();

            return "";
        }
    }
}