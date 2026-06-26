
import java.util.*;

/**
 * This class provides a solution to the problem of finding the minimum time required to swim in water.
 * 
 * Approach: 
 * Uses a Union-Find algorithm to track the connectivity of the grid cells. 
 * The algorithm starts by initializing the parent array and then iterates over the grid cells in ascending order of their values. 
 * For each cell, it checks its adjacent cells and performs a union operation if the adjacent cell is already visited. 
 * The algorithm returns the minimum time required to swim in water when the top-left cell is connected to the bottom-right cell.
 * 
 * Time Complexity: 
 * O(n^2 * alpha(n)) where n is the number of cells in the grid and alpha(n) is the inverse Ackermann function.
 * 
 * Space Complexity: 
 * O(n) where n is the number of cells in the grid.
 */
public class Solution {
    class Solution {
    ArrayList<Integer> parent=new ArrayList<>();
    public int fp(int u){
        if(u!=parent.get(u)){
            parent.set(u,fp(parent.get(u)));
        }
        return parent.get(u);
    }
    public void union(int u, int v){
        int ulp=fp(u);
        int vlp=fp(v);

        if(ulp!=vlp){
            parent.set(vlp,ulp);
        }
    }
    public int swimInWater(int[][] grid) {
        for(int i=0;i<grid.length*grid.length;i++){
            parent.add(i);
        }

        int[][] positions=new int [grid.length*grid.length][2];
        int maxtime=0;

        int[][] flag=new int [grid.length][grid.length];

        for(int[] i: flag){
            Arrays.fill(i,0);
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                int value=grid[i][j];
                positions[value][0]=i;
                positions[value][1]=j;
                maxtime=Math.max(value,maxtime);
            }
        }

        int[] xd={-1,0,1,0};
        int[] yd={0,-1,0,1};

        for(int i=0;i<=maxtime;i++){
            int row=positions[i][0];
            int col=positions[i][1];

            flag[row][col]=1;

            for(int j=0;j<4;j++){
                int nr=row+xd[j];
                int nc=col+yd[j];

                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid.length && flag[nr][nc]==1){
                    int idx=row*grid.length+col;
                    int adjidx=nr*grid.length+nc;

                    union(idx,adjidx);
                }
            }

            if(fp(0)== fp(grid.length*grid.length-1)){
                return i;
            }
        }
        return maxtime;
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid1 = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        int[][] grid2 = {{3,2,1},{1,1,1},{0,2,4}};
        int[][] grid3 = {{0,0,0},{0,0,0},{0,0,0}};

        System.out.println("Test Case 1: " + solution.swimInWater(grid1));
        System.out.println("Test Case 2: " + solution.swimInWater(grid2));
        System.out.println("Test Case 3: " + solution.swimInWater(grid3));
    }
}
