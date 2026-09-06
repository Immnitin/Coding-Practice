import java.util.*;
/**
 * Solution for the House Robber problem.
 *
 * <p>Approach:
 * The algorithm iterates the houses array from right to left, maintaining two variables
 * {@code prev1} and {@code prev2} which represent the maximum amount that can be robbed
 * from the next house and the house after next, respectively. For each house we compute
 * the amount if we rob it ({@code take = nums[i] + prev2}) and the amount if we skip it
 * ({@code ntake = prev1}). The current maximum is {@code Math.max(take, ntake)} and the
 * variables are shifted for the next iteration. This is a space‑optimized bottom‑up
 * dynamic programming solution.
 *
 * Time Complexity: O(n), where n is the number of houses.
 * Space Complexity: O(1) additional space.
 */
class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+2];
        // Arrays.fill(dp,-1);
        // return robbery(nums, 0,dp);

        // dp[nums.length]=0;
        // dp[nums.length+1]=0;

        int prev1=0;
        int prev2=0;
        
        for(int i=nums.length-1;i>=0;i--){
            // int take= nums[i]+dp[i+2];
            // int ntake=dp[i+1];
            // dp[i]=Math.max(take, ntake);
            int take=nums[i]+prev2;
            int ntake=prev1;
            prev2=prev1;
            prev1=Math.max(take,ntake);

        }
        return prev1;
        // return dp[0];
    }
    public int robbery(int[] nums, int idx, int[] dp){
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int take=nums[idx]+robbery(nums,idx+2, dp);
        int ntake=robbery(nums,idx+1, dp);

        return dp[idx]=Math.max(take,ntake);
    }
}

public class Driver {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] testCases = {
            {2,7,9,3,1},
            {1,2,3,1},
            {2,1,1,2}
        };
        for (int i = 0; i < testCases.length; i++) {
            int result = sol.rob(testCases[i]);
            System.out.println("Test case " + (i+1) + ": " + result);
        }
    }
}