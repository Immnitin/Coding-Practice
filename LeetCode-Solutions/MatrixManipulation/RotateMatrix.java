import java.util.Arrays;

/**
 * This class provides a method to rotate a given matrix 90 degrees clockwise in-place.
 * 
 * @author [Your Name]
 */
public class Solution {
    /**
     * Rotates a given matrix 90 degrees clockwise in-place.
     * 
     * <p>Approach: Uses a two-step approach to rotate the matrix. First, it transposes the matrix by swapping elements across the diagonal. Then, it reverses each row to achieve the desired rotation.
     * 
     * <p>Time Complexity: O(n^2), where n is the number of rows (or columns) in the matrix, since we are iterating over the entire matrix twice.
     * 
     * <p>Space Complexity: O(1), since we are modifying the input matrix in-place and not using any additional space that scales with the input size.
     * 
     * @param matrix the input matrix to be rotated
     */
    class Solution {
    public void rotate(int[][] matrix) {
         for(int i=0;i<matrix.length;i++){
       for(int j=i+1;j<matrix[i].length;j++){
          int temp=matrix[i][j];
          matrix[i][j]=matrix[j][i];
          matrix[j][i]=temp;
       }
     }
    for(int i=0;i<matrix.length;i++){
      int start=0;
      int end=matrix[i].length-1;
        while(start<=end){
          int temp=matrix[i][start];
          matrix[i][start]=matrix[i][end];
          matrix[i][end]=temp;
          start++;
          end--;
        }
    }
    }
}
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(matrix1);
        System.out.println("Rotated Matrix 1:");
        for (int[] row : matrix1) {
            System.out.println(Arrays.toString(row));
        }

        int[][] matrix2 = {{1, 2}, {3, 4}};
        solution.rotate(matrix2);
        System.out.println("Rotated Matrix 2:");
        for (int[] row : matrix2) {
            System.out.println(Arrays.toString(row));
        }

        int[][] matrix3 = {{1}};
        solution.rotate(matrix3);
        System.out.println("Rotated Matrix 3:");
        for (int[] row : matrix3) {
            System.out.println(Arrays.toString(row));
        }
    }
}