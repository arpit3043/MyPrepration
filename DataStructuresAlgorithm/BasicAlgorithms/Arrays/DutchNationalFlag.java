package BasicAlgorithms.Arrays;
public class DutchNationalFlag {
    public static void main(String[] args) throws Exception {
        int[] arr = {1,1,0,0,1,1,2,2,0,0};
        sortArrayOfColors(arr);
        printArray(arr);
    }
    private static void sortArrayOfColors(int[] nums) {
        int N = nums.length;
        int start = 0;
        int end = N-1;
        int mid = 0;
        while(mid<=end) {
            if(nums[mid]==0) {
                swap(nums, mid, start);
                start++;
            } else if(nums[mid]==2) {
                swap(nums, mid, end);
                end--;
                continue;
            }
            mid++;
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