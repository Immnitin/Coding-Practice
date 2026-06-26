
import java.util.PriorityQueue;

/**
 * This class provides a solution to the minimum cost to connect points problem.
 * 
 * Approach: 
 * Uses a Priority Queue to implement Prim's algorithm for finding the Minimum Spanning Tree (MST) of a graph.
 * The algorithm starts by selecting an arbitrary node and adding it to the visited set. 
 * Then, it iteratively selects the edge with the minimum weight that connects a visited node to an unvisited node, 
 * and adds the unvisited node to the visited set. This process continues until all nodes have been visited.
 * 
 * Time Complexity: 
 * The time complexity of this solution is O(E log E) or O(E log V), where E is the number of edges and V is the number of vertices.
 * This is because each edge is inserted into the priority queue once, and the priority queue operations (insertion and deletion) take O(log E) time.
 * 
 * Space Complexity: 
 * The space complexity of this solution is O(V + E), where V is the number of vertices and E is the number of edges.
 * This is because we need to store the visited array, the priority queue, and the graph.
 */
public class Solution {
    class Solution {

    class Info {
        int node, parent, wt;

        public Info(int node, int parent, int wt) {
            this.node = node;
            this.parent = parent;
            this.wt = wt;
        }
    }

    public int minCostConnectPoints(int[][] points) {

        PriorityQueue<Info> pq =
                new PriorityQueue<>((a, b) -> a.wt - b.wt);

        int[] visited = new int[points.length];
        int twt = 0;

        pq.offer(new Info(0, -1, 0));

        while (!pq.isEmpty()) {

            Info curr = pq.poll();

            if (visited[curr.node] == 1)
                continue;

            twt += curr.wt;
            visited[curr.node] = 1;

            for (int i = 0; i < points.length; i++) {

                if (i == curr.node)
                    continue;

                if (visited[i] == 0) {

                    int x1 = points[i][0];
                    int y1 = points[i][1];

                    int x2 = points[curr.node][0];
                    int y2 = points[curr.node][1];

                    int dist =
                            Math.abs(x1 - x2) +
                            Math.abs(y1 - y2);

                    pq.offer(new Info(i, curr.node, dist));
                }
            }
        }

        return twt;
    }
}


}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] points1 = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println("Test Case 1: " + solution.minCostConnectPoints(points1));
        
        int[][] points2 = {{3, 12}, {-7, 3}, {5, 3}, {13, 4}};
        System.out.println("Test Case 2: " + solution.minCostConnectPoints(points2));
        
        int[][] points3 = {{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}};
        System.out.println("Test Case 3: " + solution.minCostConnectPoints(points3));
    }
}
