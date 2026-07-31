
/**
 * This class provides a solution to the matrix search problem.
 * 
 * @author [Your Name]
 * @version 1.0
 */
import java.util.*;

/**
 * Approach: 
 * Uses a modified binary search algorithm to search for a target element in a sorted matrix.
 * The matrix is treated as a one-dimensional sorted array, and the binary search algorithm is applied.
 * 
 * Time Complexity: 
 * O(log(m*n)) where m is the number of rows and n is the number of columns in the matrix.
 * 
 * Space Complexity: 
 * O(1) as no extra space is used.
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return bs(matrix, target, 0, matrix.length*matrix[0].length-1);
    }

    public boolean bs(int[][] matrix, int target, int st, int ed){
        if(st>ed){
            return false;
        }

        int strow=st/matrix[0].length;
        int stcol=st%matrix[0].length;

        int edrow=ed/matrix[0].length;
        int edcol=ed%matrix[0].length;

        int mid=matrix[strow][edcol];

        if(mid==target){
            return true;
        }

        else if(mid<target){
            return bs(matrix,target, st+matrix[0].length,ed);
        }

        else{
            return bs(matrix,target, st, ed-1);
        }
    }
}

/**
 * Driver class to test the searchMatrix method.
 */
class Driver {
   public static void main(String[] args) {
      Solution solution = new Solution();
      
      // Test case 1:
      int[][] matrix1 = {
         {1,   4,  7, 11, 15},
         {2,   5,  8, 12, 19},
         {3,   6,  9, 16, 22},
         {10, 13, 14, 17, 24},
         {18, 21, 23, 26, 30}
      };
      int target1 = 5;
      System.out.println("Test case 1: " + solution.searchMatrix(matrix1, target1));
      
      // Test case 2:
      int[][] matrix2 = {
         {1,   4,  7},
         {2,   5,  8},
         {3,   6,  9}
      };
      int target2 = 9;
      System.out.println("Test case 2: " + solution.searchMatrix(matrix2, target2));
      
      // Test case 3:
      int[][] matrix3 = {
         {1,   4},
         {2,   5}
      };
      int target3 = 4;
      System.out.println("Test case 3: " + solution.searchMatrix(matrix3, target3));
   }
}
