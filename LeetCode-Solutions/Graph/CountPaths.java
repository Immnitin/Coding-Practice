
import java.util.*;

/**
 * This class provides a solution to the problem of counting the number of paths in a graph.
 * 
 * Approach: 
 * Uses Dijkstra's algorithm with a priority queue to efficiently explore the graph and calculate the shortest distances.
 * The algorithm iteratively selects the node with the minimum distance, updates the distances of its neighbors, and keeps track of the number of ways to reach each node.
 * 
 * Time Complexity: 
 * O(E + V log V), where E is the number of edges and V is the number of vertices, due to the use of a priority queue.
 * 
 * Space Complexity: 
 * O(V + E), for storing the adjacency list and the priority queue.
 */
public class CountPaths {
    class Solution {
    class info{
        int node;
        long dist;
        public info(int node,long dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adjlist=new ArrayList<>();
        long[] dist=new long [n];
        int[] ways=new int[n];
        PriorityQueue<info> pq=new PriorityQueue<>((a,b)->Long.compare(a.dist,b.dist));
        int mod=1000000000+7;

        Arrays.fill(dist,Long.MAX_VALUE);
        Arrays.fill(ways,0);
        for(int i=0;i<n;i++){
            adjlist.add(new ArrayList<>());
        }

        for(int i=0;i<roads.length;i++){
            adjlist.get(roads[i][0]).add(new int[]{roads[i][1],roads[i][2]});
            adjlist.get(roads[i][1]).add(new int[]{roads[i][0],roads[i][2]});

        }

        pq.offer(new info(0,0));
        dist[0]=0;
        ways[0]=1;

        while(!pq.isEmpty()){
            info nodedet=pq.poll();
            for(int[] adjnode:adjlist.get(nodedet.node)){
                if(dist[adjnode[0]]==nodedet.dist+adjnode[1]){
                    ways[adjnode[0]]=(ways[nodedet.node]+ways[adjnode[0]])%mod;
                }
                else if(dist[adjnode[0]]>nodedet.dist+adjnode[1]){
                    dist[adjnode[0]]=nodedet.dist+adjnode[1];
                    pq.offer(new info(adjnode[0],dist[adjnode[0]]));
                    ways[adjnode[0]]=ways[nodedet.node];
                    // System.out.println(nodedet.node+" "+nodedet.dist+" "+adjnode[1]);
                }
                // System.out.println(Arrays.toString(ways));
                // System.out.println(Arrays.toString(dist));

            }
        }

        return ways[ways.length-1]%mod;
    }
}

    public static class Driver {
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[][] roads1 = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
            System.out.println(solution.countPaths(7, roads1));
            
            int[][] roads2 = {{0, 1, 10}, {1, 2, 1}, {2, 0, 1}};
            System.out.println(solution.countPaths(3, roads2));
            
            int[][] roads3 = {{0, 1, 1}, {1, 2, 1}, {2, 0, 1}};
            System.out.println(solution.countPaths(3, roads3));
        }
    }
}
