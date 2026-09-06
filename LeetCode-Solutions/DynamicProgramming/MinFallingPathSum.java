import java.util.*;\n\n/**\n * Solution for Minimum Falling Path Sum problem.\n *\n * Approach:\n * The algorithm uses recursion with memoization (top‑down dynamic programming).\n * Starting from the bottom row, it recursively computes the minimum path sum to each cell\n * by considering the three possible cells in the row above (up‑left, up, up‑right).\n * Results are cached in a dp array to avoid recomputation.\n *\n * Time Complexity: O(m * n) where m is the number of rows and n the number of columns,\n * because each cell is computed once.\n *\n * Space Complexity: O(m * n) for the dp memoization table plus O(m) recursion stack depth.\n */\nclass Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            min = Math.min(min, recursion(matrix, dp, matrix.length - 1, i));
        }
        return min;
    }

    public int recursion(int[][] matrix, int[][] dp, int row, int col) {
        if (row == 0 && col >= 0 && col < matrix[0].length) {
            return matrix[row][col];
        }
        if (row > matrix.length - 1 || col > matrix[0].length - 1 || row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }

        int left = recursion(matrix, dp, row - 1, col - 1);
        int right = recursion(matrix, dp, row - 1, col + 1);
        int down = recursion(matrix, dp, row - 1, col);

        // System.out.println(left+" "+right+" "+down);

        return dp[row][col] = matrix[row][col] + Math.min(down, Math.min(left, right));
    }
}\n\npublic class Driver {\n    public static void main(String[] args) {\n        Solution sol = new Solution();\n        int[][] test1 = {{2,1,3},{6,5,4},{7,8,9}};\n        int[][] test2 = {{-19,57},{-40,-5}};\n        int[][] test3 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};\n        System.out.println(sol.minFallingPathSum(test1)); // expected 13\n        System.out.println(sol.minFallingPathSum(test2)); // expected -59\n        System.out.println(sol.minFallingPathSum(test3)); // expected 34\n    }\n}\n