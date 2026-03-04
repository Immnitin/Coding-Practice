import java.util.Arrays;
/**
 * Approach: Uses a Depth-First Search (DFS) algorithm to traverse the graph and count the number of connected components.
 * Time Complexity: O(N^2) where N is the number of cities, because in the worst case, we are iterating over the adjacency matrix for each city.
 * Space Complexity: O(N) where N is the number of cities, because we are using a visited array of size N to keep track of visited cities.
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] visited=new int[isConnected.length];
        Arrays.fill(visited,0);
        int cnt=0;
        for(int i=0;i<isConnected.length;i++){
            if(visited[i]==0){
                cnt++;
                traversal(isConnected,i,visited);
            }
        }
        return cnt;
    }

    public void traversal(int[][] isConnected,int i,int[] visited){
        if(visited[i]!=1){
            visited[i]=1;
        }
        for(int k=0;k<isConnected.length;k++){
            if(isConnected[i][k]==1 && visited[k]==0){
                traversal(isConnected,k,visited);
            }
        }
    }
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] isConnected1 = {{1,1,0},{1,1,0},{0,0,1}};
        int[][] isConnected2 = {{1,0,0},{0,1,0},{0,0,1}};
        int[][] isConnected3 = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(solution.findCircleNum(isConnected1)); // Output: 2
        System.out.println(solution.findCircleNum(isConnected2)); // Output: 3
        System.out.println(solution.findCircleNum(isConnected3)); // Output: 1
    }
}