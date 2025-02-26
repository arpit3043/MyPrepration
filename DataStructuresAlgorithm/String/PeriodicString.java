package String;

import java.lang.String;

public class PeriodicString {

    public static void main(String[] args) {
        String A="abababab";
        System.out.println(periodOfString(A));
    }
    private static int periodOfString(String A) {
        int N=A.length();
        int[] LPS = computeLPS(A);
        int n = LPS.length;
        int startIndex = n - LPS[n - 1];
        if (startIndex < 0) {
            return 0;
        }
        for (int i = startIndex; i < n - 1; i++) {
            if (LPS[i + 1] - LPS[i] != 1) {
                return 0;
            }
        }
        return startIndex;
    }

    private static int[] computeLPS(String txt) {
        int n = txt.length();
        int[] LPS = new int[n];
        for (int i = 1; i < n; i++) {
            int x = LPS[i - 1];
            while (txt.charAt(i) != txt.charAt(x)) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = LPS[x - 1];
            }
            LPS[i] = x + 1;
        }
        return LPS;
    }
}
