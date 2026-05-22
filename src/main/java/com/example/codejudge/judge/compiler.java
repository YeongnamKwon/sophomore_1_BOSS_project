package com.example.codejudge.judge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class compiler {
    static final Logger log = Logger.getLogger("Judge");

    public String errorMessage = "";

    public boolean compile() {
        try {
            ProcessBuilder pb = new ProcessBuilder("javac", "Main.java");
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

        } catch (IOException | InterruptedException e) {
            errorMessage = e.getMessage();
            log.severe(String.format("Error : %s%nLocation : %s", e, e.getStackTrace()[0]));
            return false;
        }
    }
}