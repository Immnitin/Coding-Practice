import java.util.Arrays;

/**
 * Approach: Uses dynamic programming. A dp matrix of the same size as the obstacle grid
 * stores the number of unique paths to each cell. Cells containing an obstacle are set to 0.
 * For each non‑obstacle cell, the number of paths is the sum of the paths from the cell
 * above and the cell to the left. The answer is the value at the bottom‑right corner.
 *
 * Time Complexity: O(m * n) where m is the number of rows and n is the number of columns.
 * Space Complexity: O(m * n) for the dp matrix (can be reduced to O(n) with a 1‑D array).
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }

        dp[0][0]=1;

        for(int i=0;i<obstacleGrid.length; i++){
            int up=0, left=0;
            for(int j=0;j<obstacleGrid[0].length;j++){
                if(i==0 && j==0){continue;}
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                if(i-1>=0){
                    up=dp[i-1][j];
                }
                if(j-1>=0){
                    left=dp[i][j-1];
                }
                dp[i][j]=up+left;
            }

        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];

        // return memoization(obstacleGrid, dp, obstacleGrid.length-1, obstacleGrid[0].length-1);
    }
    public int memoization(int[][] grid, int[][] dp, int i, int j){
        if(i==0 && j==0){
            
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(grid[i][j]==1){
            return 0;
        }
        int up=memoization(grid, dp, i-1,j);
        int left=memoization(grid,dp, i, j-1);
        return dp[i][j]=up+left;
    }
}

public class Driver {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid1 = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(sol.uniquePathsWithObstacles(grid1)); // Expected 2
        int[][] grid2 = {{0,1},{0,0}};
        System.out.println(sol.uniquePathsWithObstacles(grid2)); // Expected 1
        int[][] grid3 = {{1,0},{0,0}};
        System.out.println(sol.uniquePathsWithObstacles(grid3)); // Expected 0
    }
}
