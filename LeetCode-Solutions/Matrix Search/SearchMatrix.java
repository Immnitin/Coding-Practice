import java.util.Arrays;

/**
 * Approach: Uses a Binary Search algorithm to find the target element in a sorted matrix.
 * The matrix is treated as a one-dimensional sorted array, and the binary search is applied to it.
 * The row and column indices are calculated using the mid index and the number of columns in the matrix.
 *
 * Time Complexity: O(log(m*n)), where m is the number of rows and n is the number of columns in the matrix.
 * Space Complexity: O(log(m*n)), due to the recursive call stack.
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        return bs(matrix,target,0,(n*m)-1);
    }

    public boolean bs(int[][]matrix, int target, int st, int ed){
        if(st>ed){
            return false;
        }

        int mid=(st+ed)/2;
        int row=mid/matrix[0].length;
        int col=mid%matrix[0].length;

        if(matrix[row][col]==target){
            return true;
        }
        
        else if(matrix[row][col]>target){
            return bs(matrix,target,st,mid-1);
        }

        else {
            return bs(matrix, target, mid+1,ed);
        }
    }
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix1 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(solution.searchMatrix(matrix1, 3)); // true
        System.out.println(solution.searchMatrix(matrix1, 13)); // false
        int[][] matrix2 = {{1, 3}};
        System.out.println(solution.searchMatrix(matrix2, 3)); // true
    }
}