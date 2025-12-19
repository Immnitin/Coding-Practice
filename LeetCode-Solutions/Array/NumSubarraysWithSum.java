import java.util.Arrays;
/**
 * Approach: Uses a Sliding Window technique to track the sum of subarrays and count the number of subarrays with a given sum.
 * Time Complexity: O(n), where n is the length of the input array, because each element is visited at most twice.
 * Space Complexity: O(1), because only a constant amount of space is used to store variables.
 */
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int kcnt=subcnt(nums,goal);
        int k1cnt=subcnt(nums,goal-1);
        return kcnt-k1cnt;
    }
    public int subcnt(int[] nums,int k){
        if(k<0){
            return 0;
        }
        int lt=0;
        int rt=0;
        int cnt=0;
        int sum=0;
        while(rt<nums.length){
            sum+=nums[rt];
            while(sum>k && lt<nums.length){
                sum-=nums[lt];
                lt++;
            }
            if(sum<=k){
                cnt+=(rt-lt+1);
            }
            rt++;
        }
        return cnt;
    }
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {1, 2, 3},
            {1, 2, 3, 4, 5},
            {10, 2, -2, -20, 10}
        };
        int[] goals = {3, 5, -8};
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Input: nums = " + Arrays.toString(testCases[i]) + ", goal = " + goals[i]);
            System.out.println("Output: " + solution.numSubarraysWithSum(testCases[i], goals[i]));
            System.out.println();
        }
    }
}