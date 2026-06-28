import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class provides a solution to find critical connections in a graph.
 * <p>
 * Approach: Uses Depth-First Search (DFS) to traverse the graph and identify critical connections.
 * The algorithm works by maintaining a low value and an in-time value for each node. The low value represents the smallest in-time value reachable from the current node, and the in-time value represents the order in which the node was visited. A critical connection is identified when the low value of a child node is greater than the in-time value of its parent node.
 * <p>
 * Time Complexity: O(N + M), where N is the number of nodes and M is the number of edges, since each node and edge is visited once.
 * <p>
 * Space Complexity: O(N + M), for storing the adjacency list and the visited, low-time, and in-time arrays.
 */
public class Solution {
    class Solution {
    int time=0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adjlist=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();

        for(int i=0;i<n;i++){
            adjlist.add(new ArrayList<>());
        }

        for(int i=0;i<connections.size();i++){
            int u=connections.get(i).get(0);
            int v=connections.get(i).get(1);
            adjlist.get(u).add(v);
            adjlist.get(v).add(u);
        }

        int[] visited=new int[n];
        int[] lowtime=new int[n];
        int[] intime=new int[n];

        Arrays.fill(lowtime,0);
        Arrays.fill(intime,0);
        Arrays.fill(visited,0);

        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfscheck(i,i,adjlist,visited,lowtime,intime,result);
            }
        }

        return result;

    }

    public List<List<Integer>> dfscheck(int v, int parent, ArrayList<ArrayList<Integer>> adjlist,int[] visited, int[] lowtime, int[] intime, List<List<Integer>> result){
        visited[v]=1;
        lowtime[v]=time;
        intime[v]=time;
        time++;

        for(int child:adjlist.get(v)){
            if(child==parent){
                continue;
            }
            if(visited[child]==1){
                lowtime[v]=Math.min(lowtime[v], intime[child]);
            }
            if(visited[child]==0){
                dfscheck(child,v,adjlist,visited,lowtime,intime,result);
                // for eg 1 v=1, child=3
                lowtime[v]=Math.min(lowtime[child],lowtime[v]);
                if(lowtime[child]>intime[v]){
                    result.add(new ArrayList<>(Arrays.asList(child,v)));
                }
            }
        }
        return result;

    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(new ArrayList<>(Arrays.asList(0, 1)));
        connections.add(new ArrayList<>(Arrays.asList(1, 2)));
        connections.add(new ArrayList<>(Arrays.asList(2, 0)));
        connections.add(new ArrayList<>(Arrays.asList(1, 3)));
        System.out.println(solution.criticalConnections(n, connections));

        n = 6;
        connections = new ArrayList<>();
        connections.add(new ArrayList<>(Arrays.asList(0, 1)));
        connections.add(new ArrayList<>(Arrays.asList(1, 2)));
        connections.add(new ArrayList<>(Arrays.asList(2, 0)));
        connections.add(new ArrayList<>(Arrays.asList(1, 3)));
        connections.add(new ArrayList<>(Arrays.asList(3, 4)));
        connections.add(new ArrayList<>(Arrays.asList(4, 5)));
        connections.add(new ArrayList<>(Arrays.asList(5, 3)));
        System.out.println(solution.criticalConnections(n, connections));
    }
}