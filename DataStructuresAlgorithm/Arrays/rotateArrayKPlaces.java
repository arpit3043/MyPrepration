package Arrays;
public class rotateArrayKPlaces {
    public static void main(String[] args) throws Exception {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 2;
        rotateArrayByKPlaces(arr,k);
        printArray(arr);
    }

    private static void rotateArrayByKPlaces(int[] nums, int k) {
        int n = nums.length;
        k=k%n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private static void reverse(int[] arr, int s, int e) {
        while(s<e) {
            swap(arr, s, e);
            s++;
            e--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr) {
        int N = arr.length;
        for(int i=0; i<N; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}