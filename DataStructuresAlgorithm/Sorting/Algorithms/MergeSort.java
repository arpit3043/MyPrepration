package Sorting.Algorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Sorted Array: " + Arrays.toString(mergeSort(arr)));
    }

    private static int[] mergeSort(int[] nums) {
        int n = nums.length;
        mergeSortHelper(nums, 0, n-1);
        return nums;
    }
    
    private static void mergeArray(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
            
        int[] temp = new int[high-low+1];
        int k=0;
            
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[k] = nums[left];
                left++;
                k++;
            } else {
                temp[k] = nums[right];
                right++;
                k++;
            }
        }
    
        while(left<=mid) {
            temp[k] = nums[left];
            left++;
            k++;
        }
    
        while(right<=high) {
            temp[k] = nums[right];
            right++;
            k++;
        }
    
        for(int i=low; i<=high; i++) {
            nums[i] = temp[i-low];
        }
    }
    
    private static void mergeSortHelper(int[] arr, int low, int high) {
        if(low>=high) {
            return;
        }
        int mid = low + (high-low)/2;
        mergeSortHelper(arr, low, mid);
        mergeSortHelper(arr, mid+1, high);
        mergeArray(arr, low, mid, high);
    }
}    