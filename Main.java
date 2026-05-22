import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int max = sc.nextInt();

        for (int i = 1; i < N; i++) {
            int num = sc.nextInt();

            if (num > max) {
                max = num;
            }
        }

        System.out.println(max);
    }
}