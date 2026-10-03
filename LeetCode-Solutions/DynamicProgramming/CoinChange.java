import java.util.*;\n\n/**\n * Solution for the Coin Change problem.\n *\n * Approach: Uses a bottom‑up dynamic programming table where dp[i][a]\n * represents the minimum number of coins needed to make amount a using the\n * first i+1 coin denominations. The table is filled iteratively, first\n * handling the base cases for zero amount and for using only the smallest\n * coin, then building up using the recurrence:\n *   dp[i][a] = min(dp[i‑1][a], 1 + dp[i][a‑coins[i]])\n * where the first term corresponds to not taking the i‑th coin and the\n * second term corresponds to taking it. If the final entry exceeds the\n * requested amount, the method returns -1 indicating that the amount cannot\n * be formed.\n *\n * Time Complexity: O(n * amount) where n is the number of coin types.\n * Space Complexity: O(n * amount) for the DP table.\n */\nclass Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int[][] dp=new int[coins.length][amount+1];
        
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }

            for(int i=0;i<dp.length;i++){
                dp[i][0]=0;
            }

            for(int i=0;i<dp[0].length;i++){
                dp[0][i]=amount+1;
            }
            for(int amt = coins[0]; amt < dp[0].length; amt++){
    if(amt % coins[0] == 0){
        dp[0][amt] = amt / coins[0];
    }
}

            for(int idx=1;idx<dp.length;idx++){
                for(int amt=1;amt<dp[0].length;amt++){
                    int ntake= dp[idx-1][amt];
                    int take=amount+1;
                    if(amt>=coins[idx]){
                        take= 1+dp[idx][amt-coins[idx]];
                    }
                    dp[idx][amt]=Math.min(take,ntake);
                }
            }

            return dp[coins.length - 1][amount] > amount? -1: dp[coins.length - 1][amount];
        // int ans = count(coins,dp, coins.length - 1, amount);
        // return ans >= 1_000_000 ? -1 : ans;
    }

    public int count(int[] arr, int[][] dp, int idx, int sum) {

        if (sum == 0) {
            return 0;
        }

        if (sum<0 ||idx < 0) {
            return 1_000_000;
        }

         if(dp[idx][sum]!=-1){
            return dp[idx][sum];
        }

        int take = 1_000_000;

        if (sum >= arr[idx]) {
            take = 1 + count(arr,dp, idx, sum - arr[idx]);
        }

        int ntake = count(arr,dp, idx - 1, sum);

        return dp[idx][sum]=Math.min(take, ntake);
    }
}\n\npublic class Driver {\n    public static void main(String[] args) {\n        Solution sol = new Solution();\n        int[] coins1 = {1, 2, 5};\n        int amount1 = 11;\n        System.out.println(sol.coinChange(coins1, amount1)); // Expected: 3\n        int[] coins2 = {2};\n        int amount2 = 3;\n        System.out.println(sol.coinChange(coins2, amount2)); // Expected: -1\n        int[] coins3 = {1};\n        int amount3 = 0;\n        System.out.println(sol.coinChange(coins3, amount3)); // Expected: 0\n    }\n}