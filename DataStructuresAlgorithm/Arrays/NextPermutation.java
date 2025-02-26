package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.String;
import java.lang.Integer;
public class NextPermutation {
    public static void main(String[] args) throws Exception {
        List<Integer>arr = new ArrayList<>(Arrays.asList(3,2,1));
        nextPermutation(arr);
        System.out.println(arr);
    }
    private static void nextPermutation(List<Integer> nums) {
        int N = nums.size();
        int k;
        int l;
        for(k=N-2; k>=0; k--) {
            if(nums.get(k)< nums.get(k+1)) {
                break;
            }
        }
        if(k<0) {
            reverseArray(nums, 0, N-1);
        } else {
            for(l=N-1; l>k; l--) {
                if(nums.get(l)> nums.get(k)) {
                    break;
                }
            }
            swap(nums, k, l);
            if(k+1<N) {
                reverseArray(nums, k+1, N-1);
            }
        }
    }

    private static void reverseArray(List<Integer>arr, int s, int e) {
        while(s<e) {
            swap(arr, s, e);
            s++;
            e--;
        }
    }

    private static void swap(List<Integer>arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}