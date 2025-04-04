package Math;

public class CountNumber {
    public static void main(String[] args) {
        int N = 234;
        System.out.println(countDigit(N));
    }
    private static int countDigit(int n) {
        int count=0;
        if(n==0) return 1;
        while(n>0) {
            int lastDigit = n%10;
            count++;
            n = n/10;
        }
        return count;
    }
}
