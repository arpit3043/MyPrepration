package Arrays;
public class MakeItPalindrome {
    public static void main(String[] args) throws Exception {

    }
    private static int makeItAPalindrome(int[] A) {
        int ans = 0;
        long[] arr = new long[A.length];
        for(int i=0; i<A.length; i++) {
            arr[i] = (long)A[i];
        }
        int n = arr.length;
        for(int i =0, j= n-1; i<=j;) {
            if(arr[i]== arr[j]){
                i++;
                j--;
            } else if(arr[i]< arr[j]){
                i++;
                arr[i]= arr[i]+arr[i-1];
                ans++;
            } else if(arr[i] > arr[j]) {
                j--;
                arr[j] = arr[j]+ arr[j+1];
                ans++;
            }
        }
        return ans;
    }
}