import java.util.PriorityQueue;
import java.util.Arrays;
/**
 * This class provides a solution to the Minimum Effort Path problem.
 * 
 * @author [Your Name]
 * @version 1.0
 */
/**
 * Approach: Uses Dijkstra's algorithm with a priority queue to find the minimum effort path.
 * The effort to move from one cell to another is the maximum absolute difference in heights.
 * 
 * Time Complexity: O(M * N * log(M * N)) where M and N are the dimensions of the grid.
 * Space Complexity: O(M * N) for the distance array and priority queue.
 */
class Solution {
    class info{
        int row, col, abd;
        public info(int row, int col, int abd){
            this.row=row;
            this.col=col;
            this.abd=abd;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int[][] dist=new int[heights.length][heights[0].length];
        PriorityQueue<info> pq=new PriorityQueue<>((a,b)-> a.abd-b.abd);

        for(int i=0;i<dist.length;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        pq.offer(new info(0,0,0));
        dist[0][0]=0;

        int[] xd={-1,0,1,0};
        int[] yd={0,-1,0,1};
        int max=0;
        while(!pq.isEmpty()){
            info nodedet=pq.poll();
            for(int i=0;i<xd.length;i++){
                int nrow=nodedet.row+xd[i];
                int ncol=nodedet.col+yd[i];
                if(nrow>=0 && nrow<heights.length && ncol>=0 && ncol<heights[0].length){
                    max=Math.max(nodedet.abd,Math.abs(heights[nodedet.row][nodedet.col]-heights[nrow][ncol]));
                    if(dist[nrow][ncol]>max){
                        dist[nrow][ncol]=max;
                        pq.offer(new info(nrow,ncol,max));
                    }
                }
            }
        }    

        return dist[dist.length-1][dist[0].length-1];
    }
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] heights1 = {{1,2,2},{3,8,2},{5,3,5}};
        int[][] heights2 = {{1,2,1},{1,2,1}};
        int[][] heights3 = {{1,2},{2,1}};
        System.out.println("Minimum effort path for heights1: " + solution.minimumEffortPath(heights1));
        System.out.println("Minimum effort path for heights2: " + solution.minimumEffortPath(heights2));
        System.out.println("Minimum effort path for heights3: " + solution.minimumEffortPath(heights3));
    }
}