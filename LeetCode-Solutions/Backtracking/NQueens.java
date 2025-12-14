import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class solves the N-Queens problem using a backtracking approach.
 * <p>
 * Approach: Uses a recursive backtracking algorithm to place N queens on an NxN chessboard such that no two queens attack each other.
 * The algorithm tries to place a queen in each column of the current row and checks if the placement is safe. If it is safe, it recursively tries to place queens in the next row.
 * <p>
 * Time Complexity: O(N!) because in the worst case, we have to try all possible permutations of queens on the board.
 * <p>
 * Space Complexity: O(N) for the recursive call stack and the board.
 */
class Solution {
    public int totalNQueens(int n) {
        return solveNQueens(n).size();
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        nqueens(0, n, board, solutions);
        return solutions;
    }

    public static void nqueens(int row, int n, char[][] board, List<List<String>> solutions) {
        if (row == n) {
            solutions.add(boardToList(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                nqueens(row + 1, n, board, solutions);
                board[row][col] = '.'; // Backtrack
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    public static List<String> boardToList(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            result.add(new String(board[i]));
        }
        return result;
    }
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Total number of solutions for 4 queens: " + solution.totalNQueens(4));
        System.out.println("Total number of solutions for 5 queens: " + solution.totalNQueens(5));
        System.out.println("Total number of solutions for 6 queens: " + solution.totalNQueens(6));
    }
}