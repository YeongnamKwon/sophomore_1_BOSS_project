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

        final long[] maxMemory = {0};
        final boolean[] monitoring = {true};

        try {
            long start = System.nanoTime();

            ProcessBuilder pb = new ProcessBuilder("java", "Main");
            Process process = pb.start();

            long pid = process.pid();

            Thread memoryMonitor = new Thread(() -> {
                while (monitoring[0]) {
                    long memory = getProcessMemoryWindows(pid);

                    if (memory > maxMemory[0]) {
                        maxMemory[0] = memory;
                    }

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });

            memoryMonitor.start();

            long warmupStart = System.currentTimeMillis();

            while (System.currentTimeMillis() - warmupStart < 500) {
                long memory = getProcessMemoryWindows(pid);

                if (memory > maxMemory[0]) {
                    maxMemory[0] = memory;
                }

                if (maxMemory[0] > 0) {
                    break;
                }

                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    break;
                }
            }

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(process.getErrorStream())
            );

            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(process.getOutputStream())
            )) {
                writer.write(input);
                writer.newLine();
                writer.flush();
            }

            boolean finished = process.waitFor(2, TimeUnit.SECONDS);
            
            long lastMemory = getProcessMemoryWindows(pid);
            if (lastMemory > maxMemory[0]) {
                maxMemory[0] = lastMemory;
            }

            monitoring[0] = false;
            memoryMonitor.interrupt();

            if (!finished) {
                process.destroyForcibly();
                runResult.timeout = true;
                runResult.output = "";
                runResult.memory = maxMemory[0];
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
            runResult.memory = maxMemory[0];

            if (error.length() > 0) {
                runResult.runtimeError = true;
                runResult.errorMessage = error.toString();
                runResult.output = output.toString();
                return runResult;
            }

            runResult.output = output.toString();

            return runResult;

        } catch (IOException | InterruptedException e) {
            monitoring[0] = false;

            log.severe(String.format("Error : %s%nLocation : %s", e, e.getStackTrace()[0]));

            runResult.runtimeError = true;
            runResult.errorMessage = e.getMessage();
            runResult.output = "";
            runResult.memory = maxMemory[0];

            return runResult;
        }
    }

    private long getProcessMemoryWindows(long pid) {
        try {
            ProcessBuilder pb = new ProcessBuilder(
                "powershell",
                "-NoProfile",
                "-Command",
                "(Get-Process -Id " + pid + " -ErrorAction SilentlyContinue).WorkingSet64"
            );

            Process process = pb.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String line = reader.readLine();
            process.waitFor();

            if (line == null || line.isBlank()) {
                return 0;
            }

            return Long.parseLong(line.trim());

        } catch (IOException | InterruptedException | NumberFormatException e) {
            return 0;
        }
    }
}