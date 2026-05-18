package com.example.codejudge.judge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class compiler {
    static Logger log = Logger.getLogger("Judge");

    public String errorMessage = "";

    public boolean compile() {
        try {
            ProcessBuilder pb = new ProcessBuilder("javac", "Users_answercode.java");
            Process process = pb.start();

            BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(process.getErrorStream())
            );

            StringBuilder error = new StringBuilder();
            String line;

            while ((line = errorReader.readLine()) != null) {
                error.append(line).append("\n");
            }

            int result = process.waitFor();

            errorMessage = error.toString();

            return result == 0;

        } catch (Exception e) {
            errorMessage = e.getMessage();
            log.severe(String.format("Error : %s%nLocation : %s", e, e.getStackTrace()[0]));
            return false;
        }
    }
}