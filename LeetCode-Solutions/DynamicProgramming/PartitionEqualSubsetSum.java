import java.util.*;\n\n/**\n * Approach:\n * The problem is to determine if the given array can be partitioned into two subsets with equal sum.\n * We first compute the total sum of the array. If the sum is odd or the array has only one element,\n * partitioning is impossible. Otherwise we target sum/2.\n * A boolean DP table dp[i][j] indicates whether a subset of the first i+1 elements can achieve sum j.\n * The table is filled iteratively: for each element we decide to take it or not.\n * The answer is dp[n-1][target].\n *\n * Time Complexity: O(n * sum) where n is the length of the array and sum is the total sum of elements.\n *\n * Space Complexity: O(n * sum) for the DP table.\n */\nclass Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0 || nums.length==1) {
            return false;
        }
        boolean[][] dp1=new boolean[nums.length][sum];
        
        for(int i=0;i<dp1[0].length;i++){
            dp1[0][i]=false;
        }
        for(int i=0;i<dp1.length;i++){
            dp1[i][0]=true;
        }
        dp1[0][nums[0]]=true;

        for(int i=1;i<dp1.length;i++){
            for(int j=1;j<dp1[0].length;j++){
                boolean ntake=dp1[i-1][j];
                boolean take=false;
                if(j-nums[i]>=0)
                 take=dp1[i-1][j-nums[i]];
                dp1[i][j]= take || ntake;
            }
        }
        return dp1[nums.length-1][sum/2];


        // int[][] dp = new int[nums.length][sum];
        // for (int[] ar : dp) {
        //     Arrays.fill(ar, -1);
        // }
        // for(int i=;i<)

        // recursion(nums, dp, sum / 2, nums.length - 1);

        // return dp[nums.length - 1][sum / 2] == 1 ? true : false;
    }

    public int recursion(int[] nums, int[][] dp, int sum, int idx) {
        if (sum == 0) {
            return 1;
        }
        if (idx == 0) {
            return (nums[idx] == sum) ? 1 : 0;
        }
        if (dp[idx][sum] != -1) {
            return dp[idx][sum];
        }
        int ntake = recursion(nums, dp, sum, idx - 1);
        int take = 0;
        if (nums[idx] <= sum) {
            take = recursion(nums, dp, sum - nums[idx], idx - 1);
        }
        return dp[idx][sum] = take | ntake;
    }
}\n\npublic class Driver {\n    public static void main(String[] args) {\n        Solution sol = new Solution();\n        int[][] testCases = { {1,5,11,5}, {1,2,3,5}, {2,2,3,5} };\n        for (int[] arr : testCases) {\n            System.out.println(sol.canPartition(arr));\n        }\n    }\n}