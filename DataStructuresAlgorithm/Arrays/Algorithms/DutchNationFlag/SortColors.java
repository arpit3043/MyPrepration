package Arrays.Algorithms.DutchNationFlag;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 1, 1, 1, 0, 0};
        sort012(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort012(int[] arr) {
        int n = arr.length;
        int start = 0;
        int mid = 0;
        int end = n-1;
        while(mid <= end) {
            if(arr[mid] == 2) {
                swap(arr, mid, end);
                end--;
            } else if(arr[mid]==0) {
                swap(arr, start, mid);
                start++;
                mid++;
            } else {
                mid++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}