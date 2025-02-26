package Arrays.Subsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Integer;
import java.lang.String;
public class NextPermutations {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int N=arr.length;
        System.out.println(nextPermutation(N, arr));
    }
    private static List<Integer> nextPermutation(int N, int[] arr){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<N;i++) {
            list.add(arr[i]);
        }
        int index = -1;
        for(int i = N-2; i>=0; i--) {
            if(list.get(i)<list.get(i+1)){
                index = i ;
                break;
            }
        }
        if(index==-1){
            Collections.reverse(list);
            return list;
        }
        for(int i = N-1; i>index; i--) {
            if(list.get(i)>list.get(index)){
                Collections.swap(list, i , index);
                break;
            }
        }
        List<Integer> sublist = list.subList(index+1, N);
        Collections.reverse(sublist);
        return list;
    }
}
