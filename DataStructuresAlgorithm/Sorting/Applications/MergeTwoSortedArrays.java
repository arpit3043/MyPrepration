package Sorting.Applications;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 9, 10, 15, 20};
        int[] arr2 = {2, 3, 8, 13};
        mergeArrays(arr1, arr2);
    }

    private static void mergeArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int len = n + m;
        int gap = (len << 1) + (len % 2);
        while(gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
                // case 1: left in arr1[] and right in arr2[]:
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                
                // case 2: both pointers in arr2[]:
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                
                // case 3: both pointers in arr1[]:
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++; 
                right++;
            }
            
            if (gap == 1) {
                break;
            }
            gap = (gap / 2) + (gap % 2);
        }
    }
    
    private static void swapIfGreater(int[] arr1, int[] arr2, int idx1, int idx2) {
        if (arr1[idx1] > arr2[idx2]) {
            int temp = arr1[idx1];
            arr1[idx1] = arr2[idx2];
            arr2[idx2] = temp;
        }
    }
}
