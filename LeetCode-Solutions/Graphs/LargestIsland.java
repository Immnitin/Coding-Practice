
import java.util.*;

/**
 * This class contains the solution for the largest island problem.
 * 
 * Approach: 
 * Uses a Union-Find algorithm to group connected land cells together. 
 * Then, for each water cell, it calculates the size of the island that would be formed if the water cell were to be converted to a land cell.
 * 
 * Time Complexity: 
 * O(R * C), where R is the number of rows and C is the number of columns in the grid.
 * 
 * Space Complexity: 
 * O(R * C), where R is the number of rows and C is the number of columns in the grid.
 */
public class Solution {
    class Solution {
    ArrayList<Integer> parent=new ArrayList<>();
    ArrayList<Integer> size=new ArrayList<>();
    public int fp(int u){
        if(parent.get(u)!=u){
            parent.set(u,fp(parent.get(u)));
        }
        return parent.get(u);
    }

    public void union(int u, int v){
        int ulp=fp(u);
        int vlp=fp(v);

        if(ulp==vlp){
            return;
        }

        int uls=size.get(ulp);
        int vls=size.get(vlp);

        if(uls>vls){
            parent.set(vlp,ulp);
            size.set(ulp,size.get(ulp)+size.get(vlp));
            // System.out.println("parent"+parent);
            // System.out.println("size"+size);
        }
        else{
            parent.set(ulp,vlp);
            size.set(vlp, size.get(ulp)+size.get(vlp));
        //      System.out.println("parent"+parent);
        //     System.out.println("size"+size);
        }
    }
    
    public int largestIsland(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;

        for(int i=0;i<rows*cols;i++){
            parent.add(i);
            size.add(1);
        }

        int[] xd={-1,0,1,0};
        int[] yd={0,-1,0,1};

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    for(int k=0;k<4;k++){
                        int nr=i+xd[k];
                        int nc=j+yd[k];

                        if(nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc]==1){
                         int idx=i*cols+j;
                         int adjidx=nr*cols+nc;
                         if(fp(idx)!=fp(adjidx)){
                            union(idx,adjidx);
                         }
                            
                        }
                    }
                }
            }
        }

        int max=0;
        boolean flag=false;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==0){
                    int land_size=0;
                    flag=true;
                    HashSet<Integer> set=new HashSet<>();
                    for(int k=0;k<4;k++){
                        int nr=i+xd[k];
                        int nc=j+yd[k];
                        if(nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc]==1){
                            set.add(fp(nr*cols+nc));
                            //  System.out.println("parent"+parent);
                            // System.out.println("size"+ size);
                            // System.out.println(set);
                         }
                    }

                    for(int el:set){
                        land_size+=size.get(el);
                    System.out.println(land_size);
                    }
                    max=Math.max(max,land_size+1);
                }
            }
        }
        if(flag==false){
            return rows*cols;
        }

        return max;
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[][] grid1 = {
            {1, 0},
            {0, 1}
        };
        System.out.println("Test case 1: " + solution.largestIsland(grid1));
        
        // Test case 2
        int[][] grid2 = {
            {1, 1},
            {1, 0}
        };
        System.out.println("Test case 2: " + solution.largestIsland(grid2));
        
        // Test case 3
        int[][] grid3 = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 0, 0},
            {0, 1, 0, 0, 1, 0, 0},
            {0, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println("Test case 3: " + solution.largestIsland(grid3));
    }
}
