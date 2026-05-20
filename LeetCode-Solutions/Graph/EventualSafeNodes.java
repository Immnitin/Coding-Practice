import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;

/**
 * This class provides a solution to the problem of finding eventual safe nodes in a graph.
 * 
 * @author [Your Name]
 */
public class EventualSafeNodes {
    /**
     * Finds eventual safe nodes in a graph.
     * 
     * Approach: Uses a Topological Sorting algorithm to find nodes with no outgoing edges.
     * Time Complexity: O(N + M), where N is the number of nodes and M is the number of edges.
     * Space Complexity: O(N + M), where N is the number of nodes and M is the number of edges.
     * 
     * @param graph the input graph represented as an adjacency list
     * @return a list of eventual safe nodes
     */
    class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] outdeg =new int[graph.length];
        for(int i=0;i<graph.length;i++){
            outdeg[i]=graph[i].length;
        }

        ArrayList<ArrayList<Integer>> adjlist=new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            adjlist.add(new ArrayList<>());
        }

        for(int i=0;i<graph.length;i++){
            for(int j:graph[i]){
                adjlist.get(j).add(i);
            }
        }

        Queue<Integer> q=new ArrayDeque<>();

        for(int i=0;i<outdeg.length;i++){
            if(outdeg[i]==0){
                q.offer(i);
            }
        }
        System.out.println(Arrays.toString(outdeg));
        List<Integer> res=new ArrayList<>();

        while(!q.isEmpty()){
            int node=q.poll();
            res.add(node);
            for(int i:adjlist.get(node)){
                outdeg[i]--;
                if(outdeg[i]==0){
                    q.offer(i);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
}

public class Driver {
    public static void main(String[] args) {
        EventualSafeNodes solution = new EventualSafeNodes();
        int[][] graph1 = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        int[][] graph2 = {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {3, 4}};
        int[][] graph3 = {{}, {0, 2, 3, 4}, {3}, {4}, {}};
        System.out.println(solution.eventualSafeNodes(graph1));
        System.out.println(solution.eventualSafeNodes(graph2));
        System.out.println(solution.eventualSafeNodes(graph3));
    }
}