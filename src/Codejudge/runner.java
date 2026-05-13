package Codejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.concurrent.TimeUnit;

public class runner {

    public errormanager run(String input) {
        errormanager runResult = new errormanager();
        try {
            long start = System.nanoTime();
        	ProcessBuilder pb =new ProcessBuilder("java","Users_answercode.java");

            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            BufferedReader errorReader = new BufferedReader( new InputStreamReader(process.getErrorStream()));
            
            writer.write(input);
            writer.newLine();

            writer.flush();
            writer.close();

            boolean finished = process.waitFor(2,TimeUnit.SECONDS);

            if(!finished) {
                process.destroy();
                runResult .timeout = true;
                return runResult;
            }
            
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
            long end = System.nanoTime();
            runResult.runningTime = (end - start);
            
            if(error.length() > 0) {
            	runResult.runtimeError = true;
                runResult.errorMessage = error.toString();
                return runResult ;
            }
            
            runResult.output = output.toString();
            

            return runResult;

        } catch (Exception e) {

            e.printStackTrace();

            return runResult;
        }
    }
}