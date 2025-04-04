package Arrays.Subsequences;
import java.util.ArrayList;
public class LongestIncreasingSubsequence {
    public static void main(String[] args) throws Exception {
        int[] nums={10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
    private static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i=1; i<n; i++) {
            if(nums[i]>list.get(list.size()-1)) {
                list.add(nums[i]);
            } else {
                list.set(upperBound(list,nums[i]),nums[i]);
            }
        }
        return list.size();
    }

    private static int upperBound(ArrayList<Integer> list, int target) {
        int i=0;
        int j=list.size()-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(list.get(mid)<=target){
                i=mid+1;
            } else {
                j=mid-1;
            }
        }
        if(list.get(Math.max(j,0)) != target) {
            return i;
        }
        return j;
    }
}