import java.util.Arrays;\n\n/**\n * Solution for the Target Sum problem.\n * Approach: Uses a top‑down recursive approach with memoization. For each index we consider adding or subtracting the current number and store results in a DP table indexed by (index, shifted target). This avoids recomputation of overlapping sub‑problems.\n * Time Complexity: O(n * sum) where n is the length of nums and sum is the total sum of elements.\n * Space Complexity: O(n * sum) for the DP table plus recursion stack.\n */\nclass Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(Math.abs(target)>sum){
            return 0;
        }
        int[][] dp=new int[nums.length][2*sum+1];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        return formexp(nums,dp,sum,target,nums.length-1);
    }
    public int formexp(int[] nums, int[][] dp, int sum, int target, int idx){
        if(idx==0){
            int count=0;
            if(target-nums[idx]==0){
                count++;
            }
            if(target+nums[idx]==0){
                count++;
            }
            return count;
        }
        if (Math.abs(target) > sum) {
    return 0;
}
        int index=sum+target;

        if(dp[idx][index]!=-1){
            return dp[idx][index];
        }


        int sub=formexp(nums,dp,sum,target-nums[idx],idx-1);
        int add=formexp(nums,dp,sum,target+nums[idx],idx-1);

        return dp[idx][index]=sub+add;
    }
}\n\npublic class Driver {\n    public static void main(String[] args) {\n        Solution sol = new Solution();\n        int[] nums1 = {1,1,1,1,1};\n        int target1 = 3;\n        System.out.println(sol.findTargetSumWays(nums1, target1)); // Expected 5\n        int[] nums2 = {0,0,0,0,0};\n        int target2 = 0;\n        System.out.println(sol.findTargetSumWays(nums2, target2)); // Expected 32\n        int[] nums3 = {2,3,5,6,8,10};\n        int target3 = 10;\n        System.out.println(sol.findTargetSumWays(nums3, target3)); // Example output\n    }\n}\n