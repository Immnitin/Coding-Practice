
import java.util.*;

/**
 * This class provides a solution to the Cheapest Flights problem.
 * 
 * Approach: 
 * Uses a Breadth-First Search (BFS) algorithm with a priority queue to find the cheapest flight.
 * The algorithm constructs an adjacency list representation of the graph and then uses BFS to traverse the graph.
 * It keeps track of the minimum cost to reach each node and updates it whenever a cheaper path is found.
 * 
 * Time Complexity: 
 * O(n + m), where n is the number of nodes and m is the number of edges in the graph.
 * 
 * Space Complexity: 
 * O(n + m), where n is the number of nodes and m is the number of edges in the graph.
 */
public class CheapestFlights {
    class Solution {
    class info{
        int node,dist,stops;
        public info(int node, int dist, int stops){
            this.node=node;
            this.dist=dist;
            this.stops=stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adjlist=new ArrayList<>();
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            adjlist.add(new ArrayList<>());
        }
        
        for(int i=0;i<flights.length;i++){
            adjlist.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }

        Queue<info> q=new ArrayDeque<>();
        q.offer(new info(src,0,0));
        int mincost=Integer.MAX_VALUE;

        while(!q.isEmpty()){
            info nodedet=q.poll();
            if(nodedet.stops<=k+1 && nodedet.node==dst){
                mincost=Math.min(mincost,nodedet.dist);
            }
            if(nodedet.stops>k+1){
                continue;
            }
            for(int[] adjnode: adjlist.get(nodedet.node)){
                if(dist[adjnode[0]]>nodedet.dist+adjnode[1]){
                    dist[adjnode[0]]=nodedet.dist+adjnode[1];
                    q.offer(new info(adjnode[0],dist[adjnode[0]],nodedet.stops+1));
                }
            }

        }
    
        return mincost==Integer.MAX_VALUE ? -1 : mincost;

    }
}

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1:
        int n = 3;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dst = 2;
        int k = 1;
        System.out.println("Test case 1: " + solution.findCheapestPrice(n, flights, src, dst, k));

        // Test case 2:
        n = 3;
        flights = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
        src = 0;
        dst = 2;
        k = 0;
        System.out.println("Test case 2: " + solution.findCheapestPrice(n, flights, src, dst, k));

        // Test case 3:
        n = 5;
        flights = new int[][]{{0,1,5},{1,2,5},{2,3,5},{3,4,5},{4,2,5}};
        src = 0;
        dst = 4;
        k = 2;
        System.out.println("Test case 3: " + solution.findCheapestPrice(n, flights, src, dst, k));
    }
}
