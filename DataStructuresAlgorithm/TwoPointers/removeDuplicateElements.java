package TwoPointers;
public class removeDuplicateElements {
    public static void main(String[] args) throws Exception {
        int[] arr = {2, 2, 2, 2, 2};
        int N = arr.length;
        System.out.println(removeDuplicate(arr));
    }
    private static int removeDuplicate(int[] arr) {
        int i=0;
        int j=1;
        int N = arr.length;
        if(N==0) {
            return 0;
        }
        while(j<N) {
            if(arr[i]!=arr[j]) {
                i++;
                arr[i]=arr[j];
            }
            j++;
        }
        return i+1;
    }
}