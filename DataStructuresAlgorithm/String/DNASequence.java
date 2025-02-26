package String;
import java.util.Scanner;
public class DNASequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(longestRepetition(s));
        scanner.close();
    }

    private static int longestRepetition(String s) {
        int n = s.length();
        int maxRepetition = 0;
        int currentRepetition = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentRepetition++;
            } else {
                maxRepetition = Math.max(maxRepetition, currentRepetition);
                currentRepetition = 1;
            }
        }
        maxRepetition = Math.max(maxRepetition, currentRepetition);
        return maxRepetition;
    }
}
