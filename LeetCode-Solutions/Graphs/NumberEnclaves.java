import java.util.Arrays;

/**
 * This class contains a solution for the Number Enclaves problem.
 * 
 * @author [Your Name]
 */
public class NumberEnclaves {
    /*
     * Approach: Uses a Depth-First Search (DFS) algorithm to mark all the enclaves connected to the boundary of the grid.
     * Time Complexity: O(M * N), where M is the number of rows and N is the number of columns in the grid.
     * Space Complexity: O(M * N), for the visited array and the recursive call stack.
     */
    class Solution {
    
public int numEnclaves(int[][] grid) {

        // Your code here
       int[][] visited= new int[grid.length][grid[0].length];
       for(int[] vi:visited){
           Arrays.fill(vi,0);
       }
    //   print(grid);
       for(int i=0;i<grid[0].length;i++){
          if(grid[0][i]==1){
            // System.out.println(i);
              check(0,i,grid,visited);
          } 
       }
       for(int i=0;i<grid.length;i++){
           if(grid[i][grid[0].length-1]==1){
            //   System.out.println(grid[0].length-1+" "+i);
               check(i,grid[0].length-1,grid,visited);
           }
       }
       for(int i=grid[0].length-1;i>=0;i--){
           if(grid[grid.length-1][i]==1){
            //  System.out.println(i);
               check(grid.length-1,i,grid,visited);
           }
       }
       for(int i=grid.length-1;i>=0;i--){
           if(grid[i][0]==1){
               check(i,0,grid,visited);
           }
       }
    //   print(grid);
       int cnt=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
      public static void check(int r, int c, int[][] board, int[][] visited){
       board[r][c]=2;
        int[] xd={-1,0,1,0};
        int[] yd={0,-1,0,1};
        for(int i=0;i<xd.length;i++){
            int nrow=xd[i]+r;
            int ncol=yd[i]+c;
            if(nrow>=0 && nrow<board.length && ncol>=0 && ncol<board[0].length && board[nrow][ncol]==1 && visited[nrow][ncol]==0){
                    check(nrow,ncol,board,visited);
            }
        }
    }
}
}

/**
 * Driver class to test the NumberEnclaves class.
 */
public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid1 = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        int[][] grid2 = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        System.out.println("Number of enclaves in grid1: " + solution.numEnclaves(grid1));
        System.out.println("Number of enclaves in grid2: " + solution.numEnclaves(grid2));
    }
}