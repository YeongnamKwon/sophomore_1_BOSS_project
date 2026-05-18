package com.example.codejudge.judge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class runner {
    static final Logger log = Logger.getLogger("Judge");

    public errormanager run(String input) {
        errormanager runResult = new errormanager();

        try {
            long start = System.nanoTime();

            ProcessBuilder pb = new ProcessBuilder("java", "Users_answercode");
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(process.getOutputStream())
            )) {
                writer.write(input);
                writer.newLine();
                writer.flush();
            }

            BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(process.getErrorStream())
            );

            boolean finished = process.waitFor(2, TimeUnit.SECONDS);

            if (!finished) {
                process.destroyForcibly();
                runResult.timeout = true;
                runResult.output = "";
                return runResult;
            }

            StringBuilder output = new StringBuilder();
            StringBuilder error = new StringBuilder();

            String line;

            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            while ((line = errorReader.readLine()) != null) {
                error.append(line).append("\n");
            }

            long end = System.nanoTime();

            runResult.runningTime = end - start;

            Runtime runtime = Runtime.getRuntime();
            runResult.memory = runtime.totalMemory() - runtime.freeMemory();

            if (error.length() > 0) {
                runResult.runtimeError = true;
                runResult.errorMessage = error.toString();
                runResult.output = output.toString();
                return runResult;
            }

            runResult.output = output.toString();

            return runResult;

        } catch (IOException | InterruptedException e) {
            log.severe(String.format("Error : %s%nLocation : %s", e, e.getStackTrace()[0]));

            runResult.runtimeError = true;
            runResult.errorMessage = e.getMessage();
            runResult.output = "";

            return runResult;
        }
    }
}