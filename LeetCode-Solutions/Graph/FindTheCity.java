
import java.util.Arrays;

/**
 * This class provides a solution to the problem of finding the city with the minimum number of neighboring cities within a certain distance threshold.
 * 
 * Approach: 
 * The algorithm uses Floyd-Warshall's algorithm to find the shortest path between all pairs of cities. 
 * It then counts the number of neighboring cities for each city within the given distance threshold and sorts the cities based on this count. 
 * The city with the minimum count is returned as the result.
 * 
 * Time Complexity: 
 * The time complexity of this algorithm is O(n^3) due to the use of Floyd-Warshall's algorithm, where n is the number of cities.
 * 
 * Space Complexity: 
 * The space complexity of this algorithm is O(n^2) for storing the distance matrix and the city information.
 */
public class Solution {
    class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            int[][] dist=new int[n][n];
            int[][] cities=new int[n][2];

            for(int i=0;i<n;i++){
                Arrays.fill(dist[i],(int)1e8);
                dist[i][i]=0;
                cities[i][0]=i;
            }

            for(int i=0;i<edges.length;i++){
                dist[edges[i][0]][edges[i][1]]=edges[i][2];
                dist[edges[i][1]][edges[i][0]]=edges[i][2];

            }

            for(int i=0;i<dist.length;i++){
            for(int j=0;j<dist.length;j++){
                for(int k=0;k<dist.length;k++){
                    if(dist[j][i]!=(int)1e8 && dist[i][k]!=(int)1e8)
                    dist[j][k]=Math.min(dist[j][k],dist[j][i]+dist[i][k]);
                }
            }
            }
            for(int i=0;i<dist.length;i++){
                for(int j=0;j<dist.length;j++){
                    if(i!=j && dist[i][j]<=distanceThreshold){
                     cities[i][1]++;   
                    }
                }
            }

            Arrays.sort(cities,(a,b)->{
                if(a[1]!=b[1]){
                    return b[1]-a[1];
                }
                else 
                    return a[0]-b[0];
            });
            for(int[] ci:cities){

            // System.out.println(Arrays.toString(ci));
            }
            return cities[n-1][0];
        }
    }
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int n1 = 5;
        int[][] edges1 = {{0,1,2},{0,4,8},{1,2,3},{1,4,10},{2,3,1},{3,4,4}};
        int distanceThreshold1 = 6;
        System.out.println("Test case 1: " + solution.findTheCity(n1, edges1, distanceThreshold1));
        
        // Test case 2
        int n2 = 5;
        int[][] edges2 = {{0,1,2},{0,4,8},{1,2,3},{1,4,10},{2,3,1},{3,4,4}};
        int distanceThreshold2 = 7;
        System.out.println("Test case 2: " + solution.findTheCity(n2, edges2, distanceThreshold2));
        
        // Test case 3
        int n3 = 5;
        int[][] edges3 = {{0,1,2},{0,4,8},{1,2,3},{1,4,10},{2,3,1},{3,4,4}};
        int distanceThreshold3 = 5;
        System.out.println("Test case 3: " + solution.findTheCity(n3, edges3, distanceThreshold3));
    }
}
