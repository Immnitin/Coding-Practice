import java.util.Arrays;
/**
 * Approach: Uses two boolean arrays to track rows and columns that need to be zeroed out.
 * Time Complexity: O(m*n), where m is the number of rows and n is the number of columns in the matrix.
 * Space Complexity: O(m + n), for the two boolean arrays.
 */
public class Solution {
    class Solution {
    public void setZeroes(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        boolean[] row=new boolean[r];
        boolean[] col=new boolean[c];
       for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            if(matrix[i][j]==0){
                row[i]=true;
                col[j]=true;
            }
        }
       }
       for(int h=0;h<r;h++){
        for(int o=0;o<c;o++){
            if(row[h]||col[o]){
                matrix[h][o]=0;
            }
        }
       } 
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix1 = {{1,1,1},{1,0,1},{1,1,1}};
        solution.setZeroes(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
        
        int[][] matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        solution.setZeroes(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
        
        int[][] matrix3 = {{1,2,3},{4,5,6},{7,8,9}};
        solution.setZeroes(matrix3);
        System.out.println(Arrays.deepToString(matrix3));
    }
}