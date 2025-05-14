package TwoPointers;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TwoSumDuplicates {
    public static void main(String[] args) throws Exception {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);
        List<List<Integer>>result = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int start = i+1;
            int end = n-1;
            
            while(start < end) {
                if(nums[i] + nums[start] + nums[end] == 0) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    if(start < end && nums[start] == nums[start+1]) {
                        start++;
                    }

                    if(start < end && nums[end] == nums[end-1]) {
                        end--;
                    }
                    
                    start++;
                    end--;
                } else if(nums[i] + nums[start] + nums[end] < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
}
