import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * This class provides a solution to the problem of finding the shortest path in a binary matrix.
 * 
 * @author [Your Name]
 */
public class ShortestPathBinaryMatrix {
    /*
     * Approach: Uses a Breadth-First Search (BFS) algorithm to traverse the binary matrix and find the shortest path.
     * Time Complexity: O(N*M) where N is the number of rows and M is the number of columns in the matrix.
     * Space Complexity: O(N*M) for the queue and visited matrix.
     */
    class Solution {
    class info{
        int row,col,dist;
        public info(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {


        if(grid[0][0]!=0 || grid[grid.length-1][grid[0].length-1]!=0){
            return -1;
        }

        if(grid.length==1 && grid[0].length==1 && grid[0][0]==0){
            return 1;
        }

        int[][] dist=new int[grid.length][grid[0].length];
        int[][] visited= new int[grid.length][grid[0].length];

        for(int i=0;i<dist.length;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            Arrays.fill(visited[i],0);
        }

        Queue<info> q=new ArrayDeque<>();

        q.offer(new info(0,0,1));
        dist[0][0]=0;

        while(!q.isEmpty()){
            info nodedet=q.poll();
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int nrow=nodedet.row+i;
                    int ncol=nodedet.col+j;
                    if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]==0 && visited[nrow][ncol]==0){
                        dist[nrow][ncol]=nodedet.dist+1;
                        visited[nrow][ncol]=1;
                        q.offer(new info(nrow,ncol,dist[nrow][ncol]));
                    }
                }
            }
        }
        if(dist[grid.length-1][grid[0].length-1]==Integer.MAX_VALUE){
            return -1;
        }
        return  dist[grid.length-1][grid[0].length-1];
    }
}
}

class Driver {
    public static void main(String[] args) {
        ShortestPathBinaryMatrix solution = new ShortestPathBinaryMatrix();
        int[][] grid1 = {{0,1},{1,0}};
        int[][] grid2 = {{0,0,0},{1,1,0},{1,1,0}};
        int[][] grid3 = {{1,0,0},{1,1,0},{1,1,0}};
        System.out.println(solution.shortestPathBinaryMatrix(grid1));
        System.out.println(solution.shortestPathBinaryMatrix(grid2));
        System.out.println(solution.shortestPathBinaryMatrix(grid3));
    }
}