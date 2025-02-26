package String;
import java.util.Scanner;
public class StringGoodness {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        while (testCases-- > 0) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            scanner.nextLine();
            String S = scanner.nextLine();
            int result = goodnessScore(N, K, S);
            System.out.println(result);
        }
        scanner.close();
    }
    private static int goodnessScore(int N, int K, String S) {
        int score = 0;
        for (int i = 0; i < N / 2; ++i) {
            if (S.charAt(i) != S.charAt(N - i - 1)) {
                score++;
            }
        }
        return Math.abs(K - score);
    }
}