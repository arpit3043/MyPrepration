package Arrays;
import java.lang.String;
public class firstMissingrepeatingNumber {
    public static void main(String[] args) throws Exception {
        int[] arr = {1,2,3,2};
        int[] ans = findMissingRepeatingNumbers(arr);
        printArray(ans);
    }
    private static int[] findMissingRepeatingNumbers(int[] arr) {
        long N=arr.length;
        long sum=0;
        long squareSum=0;
        long sumOfNaturalNumbers=(N*(N+1))/2;
        long sumOfSquaresOfNaturalNumbers=(N*(N+1)*(2*N+1))/6;
        for (int i=0; i<N; i++) {
            sum=sum+arr[i];
            squareSum=squareSum+(long)arr[i]*(long)arr[i];
        }
        long val1=sum-sumOfNaturalNumbers;
        long val2=squareSum-sumOfSquaresOfNaturalNumbers;
        val2=val2/val1;
        long repeating=(val1+val2)/2;
        long missing=repeating-val1;
        int[] ans = {(int)repeating, (int)missing};
        return ans;
    }
    private static void printArray(int[] arr) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}