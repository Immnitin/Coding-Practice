import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Approach: Uses a Depth-First Search (DFS) or Breadth-First Search (BFS) algorithm to check if a graph is bipartite.
 * The algorithm iterates over all nodes in the graph and attempts to assign a color to each node such that no two adjacent nodes have the same color.
 * If it is possible to assign colors to all nodes, the graph is bipartite; otherwise, it is not.
 * 
 * Time Complexity: O(V + E), where V is the number of vertices (nodes) and E is the number of edges in the graph.
 * This is because in the worst case, we visit each node and edge once.
 * 
 * Space Complexity: O(V), where V is the number of vertices (nodes) in the graph.
 * This is because we need to store the color of each node.
 */
public class Solution {
    class Solution {
     int[] coloured;
       
    public boolean isBipartite(int[][] graph) {
        coloured=new int[graph.length];
         Arrays.fill(coloured,-1);
        for(int i=0;i<graph.length;i++){
            if(coloured[i]==-1){
                // if(!bfscheck(i,graph)){
                //     return false;
                // }
                if(!dfscheck(i,0,graph)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfscheck(int start,int[][] graph){
        Queue<Integer> q=new ArrayDeque<>();
        // System.out.println(start);

        q.offer(start);
        coloured[start]=0;

        while(!q.isEmpty()){
            int node=q.poll();
            int color=coloured[node];
            for(int j:graph[node]){
                if(coloured[j]==-1){
                    q.offer(j);
                    coloured[j]=1-color;
                }
                else if(coloured[j]==color){
                    return false;
                }
                // System.out.println(Arrays.toString(coloured));
            }
        }
        return true;
    }

    public boolean dfscheck(int start,int colour,int[][] graph){
        if(coloured[start]==-1){
            coloured[start]=colour;
        }
        for(int i:graph[start]){
            if(coloured[i]==-1){
                if(!dfscheck(i,1-colour,graph)){
                    return false;
                }
            }
            else if(coloured[i]==colour){
                return false;
            }
        }
        return true;
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph1 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        int[][] graph2 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        int[][] graph3 = {{1}, {0, 2, 3}, {1, 3}, {1, 2}};
        System.out.println(solution.isBipartite(graph1));  // Expected output: true
        System.out.println(solution.isBipartite(graph2));  // Expected output: false
        System.out.println(solution.isBipartite(graph3));  // Expected output: false
    }
}