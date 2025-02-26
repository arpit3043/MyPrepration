package Arrays;
public class NthRowPascalTriangle {
    public static void main(String[] args) {
        int N = 5;
        NthRowPascalTriangleGenerator(N);
    }
    private static void NthRowPascalTriangleGenerator(int N) {
        for (int c = 1; c <=N; c++) {
            System.out.print(nCr(N - 1, c - 1) + " ");
        }
        System.out.println();
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