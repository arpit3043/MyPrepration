package Arrays;
public class nonDecreasingArray {
    public static void main(String[] args) throws Exception {
        int[] arr = {8,4,6};
        int n = arr.length;
        System.out.println(isPossibleNonDecreasingArray(arr, n));
    }
    private static boolean isPossibleNonDecreasingArray(int[] arr, int n) {
        int count = 0;
        for(int i=1; i<n && count<=1; i++) {
            if(arr[i-1]>arr[i]) {
                count++;
                if(i<2 || arr[i-2]<=arr[i]) {
                    arr[i-1] = arr[i];
                } else {
                    arr[i] = arr[i-1];
                }
            }
        }
        if(count<=1) {
            return true;
        }
        return false;
    }
}