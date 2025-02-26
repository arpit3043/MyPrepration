package BasicAlgorithms.Arrays;
import java.util.Arrays;
public class SeiveEranthosis {
    public static void main(String[] args) throws Exception {
        int n= 12;
        System.out.println(countPrimes(n));
    }
    private static int countPrimes(int n) {
        if(n<2) {
            return 0;
        }
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        int count=0;
        for (int p=2; p<n; p++) {
            if(primes[p]) {
                count++;
                if((long)p*p<n) {
                    for(int i=p*p; i<n; i=i+p) {
                        primes[i]=false;
                    }
                }
            }
        }
        return count;
    }
}