import java.util.*;\n\n/**\n * Solution for solving Sudoku using backtracking.\n *\n * Approach:\n * The algorithm fills empty cells ('.') one by one using depth‑first search.\n * For each empty cell it tries digits '1' to '9' and checks if placing a digit\n * violates Sudoku rules (row, column, 3×3 sub‑grid). If a digit is safe it is placed\n * and the algorithm recurses to the next cell. If no digit leads to a solution the\n * cell is reset to '.' and the recursion backtracks. The process continues until\n * all cells are filled.\n *\n * Time Complexity:\n * In the worst case the algorithm explores up to 9 possibilities for each of the\n * N empty cells, giving O(9^N) where N ≤ 81. Practically the constraints prune the\n * search dramatically.\n *\n * Space Complexity:\n * The recursion depth is at most 81, so O(N) auxiliary space is used besides the\n * board itself.\n */\nclass Solution {
    public void solveSudoku(char[][] board) {
        solve(board,0);
    }
    public boolean solve(char[][] board,int idx){
      if(idx==board.length*board.length){
        return true;
      }
      int row=idx/9;
      int col=idx%9;
      if(board[row][col]=='.'){
        for(char num='1';num<='9';num++){
            if(safe(board,num,row,col)){
                board[row][col]=num;
                if(solve(board,idx+1)){
                    return true;
                }
                board[row][col]='.';
            }
        }
        return false;
      }
      else  
      {return solve(board,idx+1);}
    }

    public boolean safe(char[][] board, int num, int row, int col){
        for(int i=0;i<board[0].length;i++){
            if(board[row][i]==num){
                return false;
            }
        }
        
        for(int i=0;i<board.length;i++){
            if(board[i][col]==num){
                return false;
            }
        }

        int rowGp=row/3;
        int colGp=col/3;

        int boxStRow=rowGp*3;
        int boxStCol=colGp*3;

        for(int i=boxStRow;i<boxStRow+3;i++){
            for(int j=boxStCol;j<boxStCol+3;j++){
                if(board[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }
}\n\npublic class Driver {\n    public static void main(String[] args) {\n        char[][] board1 = {\n            {'5','3','.','.','7','.','.','.','.'},\n            {'6','.','.','1','9','5','.','.','.'},\n            {'.','9','8','.','.','.','.','6','.'},\n            {'8','.','.','.','6','.','.','.','3'},\n            {'4','.','.','8','.','3','.','.','1'},\n            {'7','.','.','.','2','.','.','.','6'},\n            {'.','6','.','.','.','.','2','8','.'},\n            {'.','.','.','4','1','9','.','.','5'},\n            {'.','.','.','.','8','.','.','7','9'}\n        };\n        char[][] board2 = {\n            {'.','.','9','7','4','8','.','.','.'},\n            {'7','.', '.',',',',','.',',','.',',','.'},\n            {'.','2','.',',','.',',','.',',','.',',','.'},\n            {'.',',','.',',','.',',','.',',','.',',','.'},\n            {'.',',','.',',','.',',','.',',','.',',','.'},\n            {'.',',','.',',','.',',','.',',','.',',','.'},\n            {'.',',','.',',','.',',','.',',','.',',','.'},\n            {'.',',','.',',','.',',','.',',','.',',','.'},\n            {'.',',','.',',','.',',','.',',','.',',','.'}\n        };\n        // Note: board2 is a placeholder; replace with a valid Sudoku puzzle if desired.\n        Solution solver = new Solution();\n        System.out.println("Solving board 1:");\n        solver.solveSudoku(board1);\n        printBoard(board1);\n        System.out.println();\n        System.out.println("Solving board 2:");\n        solver.solveSudoku(board2);\n        printBoard(board2);\n    }\n    private static void printBoard(char[][] board) {\n        for (char[] row : board) {\n            for (char c : row) {\n                System.out.print(c + " ");\n            }\n            System.out.println();\n        }\n    }\n}