
public class uniqueElementInArray {
    public static void main(String[] args) throws Exception {
        int[] arr = {1, 5, 7, 2, 3, 2, 5, 7, 1};
        System.out.println(uniqueElementInArray(arr));
    }
    private static int uniqueElementInArray(int[] arr) {
        int N = arr.length;
        int ans = 0;
        for(int i=0; i<N; i++) {
            ans = ans^arr[i];
        }
        return ans;
    }
}
