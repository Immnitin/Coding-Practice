
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class provides a solution to the Network Delay Time problem.
 * 
 * Approach: 
 * Uses Dijkstra's algorithm to find the shortest path from the source node to all other nodes in the graph.
 * It maintains a priority queue of nodes to be processed, where the priority of each node is its current shortest distance from the source.
 * The algorithm iteratively extracts the node with the minimum priority from the queue, updates the distances of its neighbors, and adds them to the queue if necessary.
 * 
 * Time Complexity: 
 * O(E + V log V), where E is the number of edges and V is the number of vertices.
 * This is because each edge is processed once and each vertex is inserted into the priority queue once, resulting in a total of V insertions and V extractions (each taking O(log V) time).
 * 
 * Space Complexity: 
 * O(V + E), where V is the number of vertices and E is the number of edges.
 * This is because we need to store the adjacency list representation of the graph, which requires O(V + E) space, and the priority queue, which requires O(V) space in the worst case.
 */
class Solution {
    class info{
        int node, dist;
        public info(int node, int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<info> pq=new PriorityQueue<>((a,b)-> a.dist-b.dist);
        ArrayList<ArrayList<int[]>> adjlist=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjlist.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            adjlist.get(times[i][0]).add(new int[]{times[i][1],times[i][2]});
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        dist[0]=0;
        pq.offer(new info(k,0));

        while(!pq.isEmpty()){
            info nodedet=pq.poll();
            for(int[] adjnode: adjlist.get(nodedet.node)){
                if(dist[adjnode[0]]> nodedet.dist+adjnode[1]){
                    dist[adjnode[0]]=nodedet.dist+adjnode[1];
                    pq.offer(new info(adjnode[0], dist[adjnode[0]]));
                }
            }
        }
        int max=-1;
        // System.out.println(Arrays.toString(dist));
        for(int i=0;i<dist.length;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            max=Math.max(max,dist[i]);
        }
        return max;
    }
}

public class Driver {
   public static void main(String[] args) {
       Solution solution = new Solution();
       int[][] times1 = {{1, 2, 1}, {2, 3, 2}, {1, 3, 2}};
       int n1 = 3;
       int k1 = 1;
       System.out.println("Test Case 1: " + solution.networkDelayTime(times1, n1, k1));

       int[][] times2 = {{1, 2, 1}};
       int n2 = 2;
       int k2 = 1;
       System.out.println("Test Case 2: " + solution.networkDelayTime(times2, n2, k2));

       int[][] times3 = {{1, 2, 1}, {2, 3, 2}, {1, 3, 4}};
       int n3 = 3;
       int k3 = 1;
       System.out.println("Test Case 3: " + solution.networkDelayTime(times3, n3, k3));
   }
}
