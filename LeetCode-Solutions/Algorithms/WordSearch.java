import java.util.Arrays;

/**
 * Approach: Uses a Depth-First Search (DFS) algorithm to find if a given word exists in a 2D grid of characters.
 * The algorithm iterates over each cell in the grid, and for each cell that matches the first character of the word,
 * it calls a helper function to check if the rest of the word can be formed by traversing adjacent cells.
 * 
 * Time Complexity: O(N * M * 4^L), where N is the number of rows, M is the number of columns, and L is the length of the word.
 * This is because in the worst case, we might have to explore all four directions for each cell, and we do this L times for each starting cell.
 * 
 * Space Complexity: O(N * M + L), where N is the number of rows, M is the number of columns, and L is the length of the word.
 * This is because we need to store the visited cells in the grid, and the maximum depth of the recursion call stack is L.
 */
public class Solution {
    class Solution {
    public boolean exist(char[][] board, String word) {
     int[][] visited=new int[board.length][board[0].length];
    for(int i = 0; i < board.length; i++) {
    for(int j = 0; j < board[0].length; j++) {

        if(board[i][j] == word.charAt(0)) {

            visited[i][j] = 1;

            if(check(board, visited, word, i, j, 1)) {
                return true;
            }

            visited[i][j] = 0;
        }
    }
}   
    return false;

    }
    public boolean check(char[][] board, int[][] visited, String word, int row, int col,int idx){   
        if(idx==word.length()){
            return true;
        }
        int[] xd={0,-1,0,1};
        int[] yd={-1,0,1,0};
        for(int i=0;i<xd.length;i++){
            int nrow=row+xd[i];
            int ncol=col+yd[i];
            if(nrow>=0 && nrow<board.length && ncol>=0 && ncol<board[0].length && board[nrow][ncol]==word.charAt(idx) && visited[nrow][ncol]==0){
                visited[nrow][ncol]=1;
                if(check(board,visited,word,nrow,ncol,idx+1)){
                    return true;
                }
                visited[nrow][ncol]=0;
            }
        }
        return false;
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board1 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(solution.exist(board1, "ABCCED")); // true
        System.out.println(solution.exist(board1, "SEE")); // true
        System.out.println(solution.exist(board1, "ABCB")); // false
    }
}