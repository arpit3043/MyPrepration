package Arrays;
public class problemSelection {
    public static void main(String[] args) throws Exception {
        int K = 3;
        int[] arr = {1, 2, 1, 2};
        long[] ans = problemSelection(arr, K);
        printArray(ans);
    }
    private static long[] problemSelection(int[] A, int K) {
        int N = A.length;
        long[] ans = new long[2];
        MergeSort(A, 0, N-1);
        long max = maxValue(A, K);
        long min = minValue(A, K);
        ans[0] = min;
        ans[1] = max;
        return ans;
    }
    private static long maxValue(int[] A, int k) {
        int N = A.length;
        int i=-1;
        int j = N-1;
        long max = 0;
        while(i<j) {
            max = max+A[j];
            i = i+k;
            j--;
        }
        return max;
    }
    private static long minValue(int[] A, int k) {
        int N = A.length;
        int i=0;
        int j = N;
        long min = 0;
        while(i<j) {
            min = min+A[i];
            i++;
            j=j-k;
        }
        return min;
    }

    private static void MergeSort(int[] arr, int start, int end) {
        int mid = start + (end-start)/2;
        if(start<end) {
            MergeSort(arr, start, mid);
            MergeSort(arr, mid+1, end);
            mergeArrays(arr, start, mid, end);
        }
    }
    private static void mergeArrays(int[] arr, int start, int mid, int end) {
        int[] left = new int[mid-start+1];
        int[] right = new int[end-mid];
        for(int i=0; i<mid-start+1; i++) {
            left[i] = arr[start+i];
        }
        for(int j=0; j<end-mid; j++) {
            right[j] = arr[mid+1+j];
        }
        int i = 0;
        int j = 0;
        int k=start;
        while(i<(mid-start+1) && j<(end-mid)) {
            if(left[i]<=right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while(i<(mid-start+1)) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while(j<(end-mid)) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }
    private static void printArray(long[] arr) {
        int N = arr.length;
        for(int i=0; i<N; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}