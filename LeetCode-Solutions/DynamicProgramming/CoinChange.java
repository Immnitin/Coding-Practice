import java.util.*;\n\n/**\n * Solution for the Coin Change problem.\n *\n * Approach:\n * The algorithm uses top‑down recursion with memoisation (DP). For each coin index and remaining sum it\n * computes the minimum number of coins needed. The state (idx, sum) is stored in a 2‑D array to avoid\n * recomputation. If the sum becomes zero the recursion returns 0. If the sum becomes negative or no coins are\n * left, a large sentinel (1_000_000) is returned which later translates to -1 (no solution).\n *\n * Time Complexity: O(n * amount) where n is the number of coin denominations, because each state is\n * computed at most once.\n *\n * Space Complexity: O(n * amount) for the memoisation table plus O(n) recursion stack in the worst case.\n */\nclass Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }

        int ans = count(coins,dp, coins.length - 1, amount);
        return ans >= 1_000_000 ? -1 : ans;
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
}\n\npublic class Driver {\n    public static void main(String[] args) {\n        Solution sol = new Solution();\n        int[] coins1 = {1, 2, 5};\n        int amount1 = 11;\n        System.out.println("Test1: " + sol.coinChange(coins1, amount1)); // Expected 3\n\n        int[] coins2 = {2};\n        int amount2 = 3;\n        System.out.println("Test2: " + sol.coinChange(coins2, amount2)); // Expected -1\n\n        int[] coins3 = {1};\n        int amount3 = 0;\n        System.out.println("Test3: " + sol.coinChange(coins3, amount3)); // Expected 0\n    }\n}\n