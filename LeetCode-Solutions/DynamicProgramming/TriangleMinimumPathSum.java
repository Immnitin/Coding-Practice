import java.util.*;

/**
 * Solution for finding the minimum path sum from top to bottom of a triangle.
 *
 * Approach:
 * The provided solution uses top‑down recursion with memoization (DP).
 * Starting from the bottom row, it recursively computes the minimum sum to reach each
 * element by considering the two possible parents from the row above. Results are cached
 * in a 2‑D array to avoid recomputation.
 *
 * Time Complexity: O(n^2) where n is the number of rows in the triangle (total number of elements).
 * Space Complexity: O(n^2) for the memoization table plus O(n) recursion stack depth.
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int min=Integer.MAX_VALUE;

        int[][] dp=new int[triangle.size()][];
        for(int i = 0; i < triangle.size(); i++) {
        dp[i] = new int[triangle.get(i).size()];
        }      

        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }

        for(int i=0;i<triangle.get(triangle.size()-1).size();i++){
            min=Math.min(min,recursion(triangle, dp, triangle.size()-1, i));
        }
        return min;
    }

    public int recursion(List<List<Integer>> triangle,int[][] dp, int i, int j){
        if(i==0){
            return triangle.get(i).get(0);
        }
        if(i<0 || i>=triangle.size() || j<0 || j>=triangle.get(i).size()){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int sc=recursion(triangle, dp, i-1,j);
        int nc=recursion(triangle, dp, i-1,j-1);
        // System.out.println(sc+" "+nc);

        return dp[i][j]=triangle.get(i).get(j) + Math.min(sc,nc);
    }
}

public class Driver {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> triangle1 = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3,4),
            Arrays.asList(6,5,7),
            Arrays.asList(4,1,8,3)
        );
        System.out.println("Minimum total (test1): " + sol.minimumTotal(triangle1));

        List<List<Integer>> triangle2 = Arrays.asList(
            Arrays.asList(-10)
        );
        System.out.println("Minimum total (test2): " + sol.minimumTotal(triangle2));

        List<List<Integer>> triangle3 = Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(2,3),
            Arrays.asList(4,5,6)
        );
        System.out.println("Minimum total (test3): " + sol.minimumTotal(triangle3));
    }
}
