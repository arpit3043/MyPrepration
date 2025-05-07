package DynamicProgramming.Arrays;
import java.util.Arrays;

public class HouseRobbery {
    public static void main(String[] args) {
        int[] houses = {
            183, 219, 57, 193, 94, 233, 202, 154, 65, 240, 97,
            234, 100, 249, 186, 66, 90, 238, 168, 128, 177, 235,
            50, 81, 185, 165, 217, 207, 88, 80, 112, 78, 135,
            62, 228, 247, 211
        };
        System.out.println(robHouses(houses));
    }
    
    private static int robHouses(int[] houses) {
        return robHelper(houses, 0);
    }

    private static int robHelper(int[] nums, int i) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        if(i>=n) {
            return 0;
        }

        if(n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        int steal = nums[i] + robHelper(nums, i+2);
        int notSteal = 0 + robHelper(nums, i+1);

        return dp[i] = Math.max(steal, notSteal);
    }
}