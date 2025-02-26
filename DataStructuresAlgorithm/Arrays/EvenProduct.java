package Arrays;
public class EvenProduct {
    public static void main(String[] args) {
        int[] A = {1,3};
        System.out.println(getDistinctStepsForEvenProduct(A));
    }
    private static int getDistinctStepsForEvenProduct(int[] A) {
        int MOD=1000*1000*1000+7;
        int N=A.length;
        int x=1;
        for(int i=1; i<=N; i++) {
            x=(x*2)%MOD;
        }
        return (x-1);
    }
}