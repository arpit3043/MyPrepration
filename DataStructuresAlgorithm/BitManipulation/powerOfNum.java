package BitManipulation;
public class powerOfNum {
    public static void main(String[] args) {
        int X = 10;
        int N = 5;
        System.out.println(powerOfNumber(X, N));
    }
    private static long powerOfNumber(int X, int N) {
        long ans=1;
        while (N>0){
            if ((N&1)==1){
                ans = ans * X;
            }
            X = X * X;
            N = N >> 1;
        }
        return ans;
    }
}