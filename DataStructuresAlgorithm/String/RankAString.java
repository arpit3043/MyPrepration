package String;

import java.util.HashMap;
import java.util.Map;
import java.lang.String;
import java.lang.Integer;
import java.lang.Character;

public class RankAString {
    public static void main(String[] args) throws Exception {
        String A = "bca";
        System.out.println(findRankInRepetitivePermutation(A));
    }

    private static int findRankInRepetitivePermutation(String A) {
        int n = A.length();
        int MOD = 1000003;
        Map<Character, Integer> map = new HashMap<>();
        long ans = 0L;
        for (int i = 0; i < n; i++) {
            char t = A.charAt(i);
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        for (int i = 0; i < n - 1; i++) {
            char x = A.charAt(i);
            long c = 0L;
            long div = 1L;
            for (int j = i + 1; j < n; j++) {
                if (A.charAt(j) < x) {
                    c++;
                }
            }
            for (char s : map.keySet()) {
                int f = factorial(map.get(s), MOD);
                div = (div * f) % MOD;
            }
            map.put(x, map.get(x) - 1);
            int inverse = powerMod(div, MOD - 2, MOD);
            long p = (((factorial(n - 1 - i, MOD) * c) % MOD) * inverse) % MOD;
            ans = (ans + p) % MOD;
        }
        return (int) ((ans + 1) % MOD);
    }

    private static int factorial(int N, int MOD) {
        if (N == 0 || N == 1) {
            return 1;
        }
        long result = 1L;
        for (int i = 2; i <= N; i++) {
            result = (result * i) % MOD;
        }
        return (int) result;
    }

    private static int powerMod(long a, int b, int MOD) {
        if (b == 0) {
            return 1;
        }
        long t = powerMod(a, b / 2, MOD);
        if (b % 2 == 0) {
            return (int) ((t * t) % MOD);
        }
        return (int) ((((t * t) % MOD) * a) % MOD);
    }
}