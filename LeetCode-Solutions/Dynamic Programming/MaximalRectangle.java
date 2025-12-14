
import java.util.Stack;

/**
 * This class provides a solution to the maximal rectangle problem.
 * 
 * Approach: 
 * Uses a histogram-based approach to calculate the maximum area of a rectangle 
 * that can be formed within a given binary matrix. The algorithm iterates over each 
 * row of the matrix, updating the heights of the histogram. It then uses a stack to 
 * calculate the maximum area of the rectangle that can be formed with the current 
 * histogram.
 * 
 * Time Complexity: 
 * O(n * m) where n is the number of rows and m is the number of columns in the matrix.
 * 
 * Space Complexity: 
 * O(m) for the heights array and the stack.
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max=0;
        int[] heights=new int[matrix[0].length];
         for(int i=0;i<matrix.length;i++){
              for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            max=Math.max(max,maxarearect(heights));
         }
         return max;
    }
    public int maxarearect(int[] heights){
        int max=0;
        Stack<Integer> stk=new Stack<>();
        for(int j=0;j<heights.length;j++){
            while(!stk.isEmpty() && heights[stk.peek()]>heights[j]){
                int curr=stk.pop();
                int pse=(stk.isEmpty()) ? -1:stk.peek();
                int nse=j;
                max=Math.max(max,heights[curr]*(nse-pse-1));
            }
            stk.push(j);
        }
        while(!stk.isEmpty()){
            int curr=stk.pop();
            int nse=heights.length;
            int pse=(stk.isEmpty()) ? -1 : stk.peek();
            max=Math.max(max,heights[curr]*(nse-pse-1));
        }
        return max;
    }
}

public class Driver {
   public static void main(String[] args) {
      Solution solution = new Solution();
      char[][] matrix1 = {
         {'1', '0', '1', '0', '0'},
         {'1', '0', '1', '1', '1'},
         {'1', '1', '1', '1', '1'},
         {'1', '0', '0', '1', '0'}
      };
      System.out.println("Maximal Rectangle Area: " + solution.maximalRectangle(matrix1));

      char[][] matrix2 = {
         {'0'}
      };
      System.out.println("Maximal Rectangle Area: " + solution.maximalRectangle(matrix2));

      char[][] matrix3 = {
         {'1', '1', '1', '1', '1'},
         {'1', '1', '1', '1', '1'},
         {'1', '1', '1', '1', '1'},
         {'1', '1', '1', '1', '1'}
      };
      System.out.println("Maximal Rectangle Area: " + solution.maximalRectangle(matrix3));
   }
}
