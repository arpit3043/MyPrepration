package Arrays;
public class swapArray {
    public static void main(String[] args) throws Exception {
        int[] arr = {2,1,6,5,9,8};
        swapAlternative(arr);
        printArray(arr);
    }
    private static void swapAlternative(int[] arr) {
        int N = arr.length;
        for(int i=0; i<N; i+=2) {
            if(i+1<N) {
                swap(arr, i, i+1);
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