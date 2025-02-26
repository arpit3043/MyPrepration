package Arrays;
public class moveZeroesAtEnd {
    public static void main(String[] args) throws Exception {
        int[] arr = {3, 5, 0, 0, 4};
        int n = arr.length;
        pushZerosToEnd(arr,n);
        printArray(arr);
    }
    private static void pushZerosToEnd(int[] arr, int n) {
        int i=0;
        for(int j=0; j<n; j++){
            if(arr[j] !=0) {
                swap(arr, j, i);
                i++;
            }
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