package BasicAlgorithms.Arrays;
public class FibonacciNumber {
    public static void main(String[] args) {
        int n=3;
        System.out.println(NthFibonacciNumber(n));
    }

    private static int NthFibonacciNumber(int n) {
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}