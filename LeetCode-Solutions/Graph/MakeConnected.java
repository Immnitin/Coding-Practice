import java.util.ArrayList;
import java.util.HashSet;

/**
 * This class provides a solution to the problem of making all computers connected in a network.
 * 
 * @author [Your Name]
 */
public class MakeConnected {
    /**
     * Approach: Uses a Disjoint Set data structure to keep track of connected components in the graph.
     * The algorithm iterates over all connections and uses the union operation to merge components.
     * If the number of extra edges is greater than or equal to the number of components minus one,
     * it returns the number of components minus one, indicating the minimum number of edges needed to make all computers connected.
     * 
     * Time Complexity: O(n + m * alpha(n)), where n is the number of computers and m is the number of connections.
     * The alpha(n) term represents the inverse Ackermann function, which grows very slowly.
     * 
     * Space Complexity: O(n), where n is the number of computers.
     */
    class Solution {
    int extra;
     class DisjointSet{
        ArrayList<Integer> parent=new ArrayList<>();
        ArrayList<Integer> size=new ArrayList<>();
        public DisjointSet(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
                size.add(1);
            }
        }

        public int findparent(int u, ArrayList<Integer> parent){
            if(parent.get(u)==u){
                return u;
            }
            int fp=findparent(parent.get(u),parent);
            parent.set(u,fp);
            return parent.get(u);
        }

        public void union(int u, int v,ArrayList<Integer> parent){
            int upu=findparent(u,parent);
            int upv=findparent(v,parent);

            if(upu==upv){
                extra++;
                return;
            }

            int upus=size.get(upu);
            int upvs=size.get(upv);

            if(upus>upvs){
                parent.set(upv,upu);
                size.set(upv, size.get(upu)+size.get(upv));
            } 
            else
                {parent.set(upu,upv);
                size.set(upv,size.get(upu)+size.get(upv));
                }
        }

     }

    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        
        if(connections.length<n-1){
            return -1;
        }

        for(int i=0;i<connections.length;i++){
            ds.union(connections[i][0],connections[i][1],ds.parent);
        }

        ArrayList<Integer> parents=ds.parent;

        HashSet<Integer> unqp=new HashSet<>();

        for(int i=0;i<parents.size();i++){
            unqp.add(ds.findparent(i,ds.parent));
        }

        int comp=unqp.size();

        if(extra>=comp-1){
            return comp-1;
        }

        return -1;        
    }
}

    public static class Driver {
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[][] connections1 = {{0, 1}, {0, 2}, {1, 2}};
            System.out.println(solution.makeConnected(3, connections1)); // Expected output: 0
            int[][] connections2 = {{0, 1}, {1, 2}, {2, 3}};
            System.out.println(solution.makeConnected(4, connections2)); // Expected output: -1
            int[][] connections3 = {{0, 1}, {0, 2}, {0, 3}};
            System.out.println(solution.makeConnected(4, connections3)); // Expected output: 1
        }
    }
}