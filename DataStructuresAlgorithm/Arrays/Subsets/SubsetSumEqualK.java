package Arrays.Subsets;
import java.util.ArrayList;
import java.util.Arrays;
public class SubsetSumEqualK {
    public static void main(String[] args) {
        ArrayList<Integer>arr = new ArrayList<>(Arrays.asList(2,4,6));
        int k=6;
        int n= arr.size();
        System.out.println(findSubsetsThatSumToK(arr, n, k));
    }
    private static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) {
        return helper(arr, 0, k);
    }
    private static ArrayList<ArrayList<Integer>> helper(ArrayList<Integer> input,int i,int k) {
        if(i>=input.size()) {
            if(k==0) {
                ArrayList<ArrayList<Integer>>temp= new ArrayList<ArrayList<Integer>>();
                temp.add(new ArrayList<Integer>());
                return temp;
            }
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> sans1= helper(input, i+1, k);
        ArrayList<ArrayList<Integer>> sans2=helper(input, i+1, k-input.get(i));
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        int rowIndex=0;
        for(int row=0; row<sans1.size(); row++) {
            ans.add(sans1.get(row));
            rowIndex++;
        }
        for (ArrayList<Integer> integers : sans2) {
            ans.add(new ArrayList<Integer>());
            ans.get(rowIndex).add(input.get(i));
            for (int col = 0; col < integers.size(); col++) {
                ans.get(rowIndex).add(integers.get(col));
            }
            rowIndex++;
        }
        return ans;
    }
}