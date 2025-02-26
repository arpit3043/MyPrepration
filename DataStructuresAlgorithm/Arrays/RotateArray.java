package Arrays;
import java.util.Scanner;
public class RotateArray {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        printArray(arr, n);
        System.out.println();
        int k = sc.nextInt();
        rotateArray(arr, k, n);
        printArray(arr, n);
    }

    private static void rotateArray(int[] arr, int k, int n) {
        if(n==0) {
            return;
        }
        k= k%n;
        if(k>n) {
            return;
        }
        int[] temp = new int[k];
        for(int i=0; i<k; i++){
            temp[i] = arr[i];
        }
        for(int i=0; i<n-k; i++) {
            arr[i] = arr[i+k];
        }
        for(int i=n-k; i<n; i++){
            arr[i] = temp[i-n+k];

        }
    }

    private static void printArray(int[] arr, int n) {
        for(int i=0; i<n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}