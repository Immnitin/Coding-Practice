import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

/**
 * This class solves the oranges rotting problem using a breadth-first search (BFS) approach.
 * <p>
 * Approach: Uses a queue to track the rotten oranges and their corresponding time. It iterates over the grid to find the rotten oranges and adds them to the queue. Then, it iterates over the queue to find the adjacent fresh oranges and adds them to the queue with an incremented time. The process continues until all fresh oranges are rotten or no more fresh oranges can be rotten.
 * <p>
 * Time Complexity: O(n*m) where n is the number of rows and m is the number of columns in the grid.
 * <p>
 * Space Complexity: O(n*m) for the queue and the visited array.
 */
public class OrangesRotting {
    class Solution {
    class rct{
        int r,c,t;
        public rct(int r, int c, int t){
            this.r=r;
            this.c=c;
            this.t=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited=new int[n][m];
        Queue<rct> q=new LinkedList<>();
        for(int i=0;i<visited.length;i++){
            Arrays.fill(visited[i],0);
        }
        int i,j;
        int cnt1=0;
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if(grid[i][j]==2){
                  q.offer(new rct(i,j,0));
                  visited[i][j]=1;
                }
                if(grid[i][j]==1){
                    cnt1++;
                }
            }
        }
        
        int[] xd={-1,0,1,0};
        int[] yd={0,1,0,-1};
        int mintime=0;
        int mcnt=0;
        
        while(!q.isEmpty()){
            rct det=q.poll();
            int r=det.r;
            int c=det.c;
            int t=det.t;
            
            mintime=Math.max(t,mintime);
            for(int p=0;p<xd.length;p++){
                int nrow=xd[p]+r;
                int ncol=yd[p]+c;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && visited[nrow][ncol]==0){
                    q.offer(new rct(nrow,ncol,t+1));
                    visited[nrow][ncol]=1;
                    mcnt++;
                }
            }
        }
        if(cnt1!=mcnt){return -1;}
        else return mintime;
    }
}
}

class Driver {
    public static void main(String[] args) {
        OrangesRotting solution = new OrangesRotting();
        int[][] grid1 = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(solution.orangesRotting(grid1));
        int[][] grid2 = {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(solution.orangesRotting(grid2));
        int[][] grid3 = {{0,2}};
        System.out.println(solution.orangesRotting(grid3));
    }
}