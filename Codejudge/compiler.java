package Codejudge;

public class compiler {

    public boolean compile() {

        try {

            ProcessBuilder pb = new ProcessBuilder("javac","Users_answercode.java");

            Process process = pb.start();

            int result = process.waitFor();

            return result == 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
}