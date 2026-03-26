import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

/**
 * This class provides a solution to the problem of updating a matrix by replacing each cell with its distance to the nearest zero.
 * 
 * @author [Your Name]
 */
public class UpdateMatrix {
    class Solution {
    class det{
        int r,c,dist;
        public det(int r, int c,int dist){
            this.r=r;
            this.c=c;
            this.dist=dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int[][] visited=new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            Arrays.fill(visited[i],0);
        }
        int[][] res=new int[mat.length][mat[0].length];
        
        for(int[] re:res){
            Arrays.fill(re,0);
        }
        
        Queue<det> q=new LinkedList<>();
        
        return bfs(mat,visited,res,q);
    }
    public int[][] bfs(int[][] grid,int[][] visited,int[][] res, Queue<det> q){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                q.offer(new det(i,j,0));
                visited[i][j]=1;
                }
            }
        }
        // for(int[] vi:visited){
        // System.out.println(Arrays.toString(vi));
        // }
        int[] xd={-1,0,1,0};
        int[] yd={0,-1,0,1};
        
        while(!q.isEmpty()){
            det curr=q.poll();
            int row=curr.r;
            int col=curr.c;
            int dist=curr.dist;
            for(int j=0;j<4;j++){
                int nrow=row+xd[j];
                int ncol=col+yd[j];
                if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]==1 && visited[nrow][ncol]==0){
                    res[nrow][ncol]=dist+1;
                    q.offer(new det(nrow,ncol,dist+1));
                    visited[nrow][ncol]=1;
                }
            }
        }
        
        return res;
    }
    
}
}

/**
 * Driver class to test the UpdateMatrix class.
 * 
 * @author [Your Name]
 */
public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testMatrix1 = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] result1 = solution.updateMatrix(testMatrix1);
        System.out.println("Result 1:");
        for (int[] row : result1) {
            System.out.println(Arrays.toString(row));
        }

        int[][] testMatrix2 = {{0,1,0,1,1},{1,1,1,0,0},{0,0,0,1,1},{1,0,1,0,1},{1,0,1,0,0}};
        int[][] result2 = solution.updateMatrix(testMatrix2);
        System.out.println("Result 2:");
        for (int[] row : result2) {
            System.out.println(Arrays.toString(row));
        }
    }
}
