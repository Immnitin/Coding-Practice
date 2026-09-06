import java.util.*;\n\n/**\n * Solution for the Unique Paths problem.\n *\n * Approach: Uses dynamic programming with a 1-dimensional array to store the number of ways\n * to reach each cell in the current row. For each row we compute a temporary array where the\n * value at column j is the sum of ways from the cell above (dp[j]) and the cell to the left\n * (temp[j-1]). This reduces the space from O(m*n) to O(n).\n *\n * Time Complexity: O(m*n) – each cell of the m×n grid is processed once.\n *\n * Space Complexity: O(n) – only two one-dimensional arrays of length n are kept.\n */\nclass Solution {
    public int uniquePaths(int m, int n) {

    int[] dp=new int[n];
    dp[0]=1;
    for(int i=0;i<m;i++){
        int[] temp=new int[n];
        for(int j=0;j<n;j++){
            int up=0,left=0;
            if(i==0 && j==0){
                temp[j]=1;
            continue;}
            if(j-1>=0){
                left=temp[j-1];
            }
                up=dp[j];
            temp[j]=left+up;
        }
        System.out.println(Arrays.toString(temp));
        dp=temp;
    }
    return dp[n-1];
    // int[][] dp=new int[m][n];
    // for(int[] arr: dp){
    //     Arrays.fill(arr,-1);
    // }

    // dp[0][0]=1;

    // for(int i=0;i<m;i++){
    //     for(int j=0;j<n;j++){
    //         if(i==0 && j==0){
    //             continue;
    //         }
    //         int up=0,left=0;
    //         if(i-1>=0){
    //             up=dp[i-1][j];
    //         }
    //         if(j-1>=0){
    //             left=dp[i][j-1];
    //         }
    //         dp[i][j]=up+left;
    //     }
    // }

    // return dp[m-1][n-1];

    // return paths(m-1,n-1,dp);    
    }
    public int paths(int m, int n, int[][] dp){
        if(m==0 && n==0){
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int up=paths(m-1, n,dp);
        int lft=paths(m,n-1,dp);

        return dp[m][n]=up+lft;
    }

}\n\nclass Driver {\n    public static void main(String[] args) {\n        Solution sol = new Solution();\n        int[][] tests = {{3,7},{3,2},{7,3}};\n        for (int[] t : tests) {\n            int m = t[0];\n            int n = t[1];\n            int result = sol.uniquePaths(m, n);\n            System.out.println(\"uniquePaths(\" + m + \",\" + n + \") = \" + result);\n        }\n    }\n}\n