package Arrays;
import java.util.Arrays;
public class MoveAllNegative {
    public static void main(String[] args) throws Exception {
        int[] a = {1, -5, -5, 3};
        System.out.println(Arrays.toString(separateNegativeAndPositive(a)));
    }
    private static int[] separateNegativeAndPositive(int[] a) {
        int N=a.length;
        int start=0;
        int end=N-1;
        while(start<end) {
            while(a[start]<0 && start<end) {
                start++;
            }
            while(a[end]>=0 && start<end) {
                end--;
            }
            if(start<end) {
                swap(a, start, end);
            }
        }
        return a;
    }

    private static void swap(int[] a, int start, int end) {
        int temp=a[start];
        a[start]=a[end];
        a[end]=temp;
    }
}