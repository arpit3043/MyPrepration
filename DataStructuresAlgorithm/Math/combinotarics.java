package Math;
public class combinotarics {
    public static void main(String[] args) {
        int N = 4;
        int R = 2;
        System.out.println(nCr(N, R));
    }
    private static int nCr(int N, int R) {
        long result = 1;
        for(int i=0; i<R; i++) {
            result = result*(N-i);
            result = result/(i+1);
        }
        return (int)result;
    }
}