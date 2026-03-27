import java.util.Arrays;

/**
 * This class solves the Surrounded Regions problem.
 * 
 * Approach: Uses a Depth-First Search (DFS) algorithm to mark all the 'O' regions connected to the boundary of the board as visited. Then, it iterates over the board and marks all the unvisited 'O' regions as 'X'.
 * 
 * Time Complexity: O(M * N), where M is the number of rows and N is the number of columns in the board.
 * 
 * Space Complexity: O(M * N), where M is the number of rows and N is the number of columns in the board.
 */
public class SurroundedRegions {
    class Solution {
    public void solve(char[][] board) {
         int[][] visited= new int[board.length][board[0].length];
       for(int[] vi:visited){
           Arrays.fill(vi,0);
       }
    //   print(board);
       for(int i=0;i<board[0].length;i++){
          if(board[0][i]=='O'){
            // System.out.println(i);
              check(0,i,board,visited);
          } 
       }
       for(int i=0;i<board.length;i++){
           if(board[i][board[0].length-1]=='O'){
            //   System.out.println(board[0].length-1+" "+i);
               check(i,board[0].length-1,board,visited);
           }
       }
       for(int i=board[0].length-1;i>=0;i--){
           if(board[board.length-1][i]=='O'){
            //  System.out.println(i);
               check(board.length-1,i,board,visited);
           }
       }
       for(int i=board.length-1;i>=0;i--){
           if(board[i][0]=='O'){
            //  System.out.println(i);
               check(i,0,board,visited);
           }
       }
       
       for(int i=0;i<board.length;i++){
         for(int j=0;j<board[0].length;j++){
           if(visited[i][j]==0){
             board[i][j]='X';
           }
         }
       }
        
    }
    public void check(int r, int c, char[][] board, int[][] visited){
       visited[r][c]=2;
        int[] xd={-1,0,1,0};
        int[] yd={0,-1,0,1};
        for(int i=0;i<xd.length;i++){
            int nrow=xd[i]+r;
            int ncol=yd[i]+c;
            if(nrow>=0 && nrow<board.length && ncol>=0 && ncol<board[0].length && board[nrow][ncol]=='O' && visited[nrow][ncol]==0){
                    check(nrow,ncol,board,visited);
            }
        }
        
        
    }
}
}

class Driver {
    public static void main(String[] args) {
        SurroundedRegions solution = new SurroundedRegions();
        char[][] board1 = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solution.solve(board1);
        System.out.println("Board 1:");
        for (char[] row : board1) {
            System.out.println(Arrays.toString(row));
        }
        
        char[][] board2 = {{'X', 'O', 'X'}, {'O', 'X', 'O'}, {'X', 'O', 'X'}};
        solution.solve(board2);
        System.out.println("Board 2:");
        for (char[] row : board2) {
            System.out.println(Arrays.toString(row));
        }
        
        char[][] board3 = {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
        solution.solve(board3);
        System.out.println("Board 3:");
        for (char[] row : board3) {
            System.out.println(Arrays.toString(row));
        }
    }
}