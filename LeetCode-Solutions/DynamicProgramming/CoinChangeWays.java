import java.util.Arrays;

/**
 * Solution for counting the number of ways to make up a given amount using
 * unlimited supply of given coin denominations.
 *
 * Approach:
 * The algorithm uses top‑down recursion with memoization (a 2‑D DP table).
 * For each coin index we decide either to skip the current coin (move to
 * idx‑1) or to take it (stay at the same idx and reduce the remaining amount).
 * The base cases are:
 *   - amount == 0 → one valid combination.
 *   - idx < 0 → no coins left, no combination unless amount is zero.
 * The DP table {@code dp[idx][amount]} stores the number of ways for a
 * particular sub‑problem to avoid recomputation.
 *
 * Time Complexity: O(n * amount) where n is the number of coin types,
 * because each state (idx, amount) is computed at most once.
 *
 * Space Complexity: O(n * amount) for the memoization table plus O(n) for
 * the recursion stack in the worst case.
 */
public class Solution {
    class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        return count(amount,dp,coins,coins.length-1);
    }

    public int count(int amount, int[][] dp, int[] coins, int idx){
        if(amount==0){
            return 1;
        }
        if(idx<0){
            return 0;
        }
        if(dp[idx][amount]!=-1){
            return dp[idx][amount];
        }
        int ntake= count(amount, dp, coins, idx-1);
        int take=0;
        if(coins[idx]<=amount){
        take=count (amount-coins[idx], dp, coins, idx);
        }
        return dp[idx][amount]=take+ntake;
    }
}
}

/**
 * Driver class to test the {@link Solution#change(int, int[])} method
 * with a few hard‑coded examples.
 */
public class Driver {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int amount1 = 5;
        int[] coins1 = {1, 2, 5};
        System.out.println("Ways to make " + amount1 + " with " + Arrays.toString(coins1) + ": " + sol.change(amount1, coins1));

        int amount2 = 3;
        int[] coins2 = {2};
        System.out.println("Ways to make " + amount2 + " with " + Arrays.toString(coins2) + ": " + sol.change(amount2, coins2));

        int amount3 = 10;
        int[] coins3 = {10};
        System.out.println("Ways to make " + amount3 + " with " + Arrays.toString(coins3) + ": " + sol.change(amount3, coins3));
    }
}
