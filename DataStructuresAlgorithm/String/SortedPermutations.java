package String;
public class SortedPermutations {
    public static void main(String[] args) throws Exception {
        String A = "acb";
        System.out.println(findRankInPermutationString(A));
    }
    private static int findRankInPermutationString(String A) {
        int MOD = 100*100*100+3;
        int N = A.length();
        int ans = 0;
        for(int i=0; i<N; i++) {
            int count=0;
            for(int j=i+1; j<N; j++) {
                if(A.charAt(j)<A.charAt(i)) {
                    count++;
                }
            }
            ans = ans+(count*factorial(N-i-1))%MOD;
        }
        return (ans+1)%MOD;
    }
    private static int factorial(int N) {
        int MOD = 100*100*100+3;
        if(N==0 || N==1) {
            return 1;
        }
        return (N*factorial(N-1))%MOD;
    }
}