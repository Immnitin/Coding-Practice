import java.util.*;
/**
 * Solution for the Coin Change 2 problem.
 *
 * Approach:
 * Uses a dynamic programming approach where dp[i] represents the number of ways
 * to make amount i using the processed coin denominations. It iteratively
 * updates the dp array for each coin, allowing unlimited usage of each coin.
 *
 * Time Complexity: O(n * amount) where n is the number of coin types.
 *
 * Space Complexity: O(amount) for the dp array.
 */
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp= new int[amount+1];
        Arrays.fill(dp,0);
        
        dp[0]=1;
        for(int i=coins[0];i<dp.length;i++){
            if(i%coins[0]==0){
                dp[i]=1;
            }
        }

            int[] curr=new int[dp.length];
            Arrays.fill(curr,0);
        for(int idx=1;idx<coins.length;idx++){
            curr[0]=1;
            for(int amt=1;amt<dp.length;amt++){
                int ntake= dp[amt];
                int take=0;
                if(amt>=coins[idx]){
                    take=curr[amt-coins[idx]];
                }
                curr[amt]=ntake+take;
            }
            dp=curr;
        }
        return dp[amount];


        // int[][] dp=new int[coins.length][amount+1];
        
        // for(int[] ar:dp){
        //     Arrays.fill(ar,-1);
        // }

        // for(int i=0;i<dp[0].length;i++){
        //     dp[0][i]=0;
        // }

        // for(int i=0;i<dp.length;i++){
        //     dp[i][0]=1;
        // }

        // for(int i=coins[0];i<dp[0].length;i++){
        //     if(i%coins[0]==0){
        //         dp[0][i]=1;
        //     }
        // }

        // for(int idx=1;idx<dp.length;idx++){
        //     for(int amt=1;amt<dp[0].length;amt++){
        //         int ntake=dp[idx-1][amt];
        //         int take=0;
        //         if(coins[idx]<=amt){
        //             take=dp[idx][amt-coins[idx]];
        //         }
        //         dp[idx][amt]=take+ntake;
        //     }
        // }

        // return dp[coins.length-1][amount];

        // return count(amount,dp,coins,coins.length-1);
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

public class Driver {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] testCoins = {
            {1, 2, 5},
            {2},
            {1, 2, 3}
        };
        int[] testAmounts = {5, 3, 4};

        for (int i = 0; i < testCoins.length; i++) {
            int result = sol.change(testAmounts[i], testCoins[i]);
            System.out.println("Amount: " + testAmounts[i] + ", Coins: " + java.util.Arrays.toString(testCoins[i]) + " => Ways: " + result);
        }
    }
}