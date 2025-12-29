import java.util.Arrays;

/**
 * This class provides a solution to count the number of negative numbers in a given grid.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class Solution {
    /**
     * Counts the number of negative numbers in a given grid.
     * 
     * Approach: Uses a simple iterative approach to traverse the grid and count the negative numbers.
     * Time Complexity: O(m*n), where m is the number of rows and n is the number of columns in the grid.
     * Space Complexity: O(1), as it only uses a constant amount of space to store the count.
     * 
     * @param grid A 2D array of integers representing the grid.
     * @return The number of negative numbers in the grid.
     */
    class Solution {
    public int countNegatives(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]<0){
                    count++;
                }
            }
        }
        return count;
    }
}
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid1 = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        int[][] grid2 = {{3, 2}, {1, 0}};
        int[][] grid3 = {{-1, -2, -3}, {-4, -5, -6}};
        System.out.println("Count of negative numbers in grid1: " + solution.countNegatives(grid1));
        System.out.println("Count of negative numbers in grid2: " + solution.countNegatives(grid2));
        System.out.println("Count of negative numbers in grid3: " + solution.countNegatives(grid3));
    }
}