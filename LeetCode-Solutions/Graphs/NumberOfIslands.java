
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class provides a solution to the Number of Islands problem.
 * 
 * Approach: Uses a Breadth-First Search (BFS) algorithm to traverse the grid and count the number of islands.
 * The algorithm iterates over each cell in the grid. If a cell is a land cell ('1') and has not been visited, it increments the island count and performs a BFS traversal from that cell to mark all connected land cells as visited.
 * 
 * Time Complexity: O(M * N), where M is the number of rows and N is the number of columns in the grid. This is because in the worst case, we might end up visiting every cell in the grid.
 * 
 * Space Complexity: O(M * N), where M is the number of rows and N is the number of columns in the grid. This is because in the worst case, the queue used for BFS traversal might contain all cells in the grid.
 */
class Solution {
    class coord{
        int row, col;
        public coord(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public int numIslands(char[][] grid) {
        char[][] visited=new char[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(visited[i],'0');
        }
        int cnt=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && visited[i][j]=='0'){
                    cnt++;
                    traversal(grid,visited,i,j);
                }
            }
        }
        return cnt;
    }

    public void traversal(char[][] grid,char[][] visited, int i, int j){
        Queue<coord> q=new LinkedList<>();
        q.offer(new coord(i,j));
        visited[i][j]='1';
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        while(!q.isEmpty()){
            coord co=q.poll();
            int row=co.row;
            int col=co.col;
            visited[row][col]='1';
            for(int d=0;d<4;d++){
                int nrow=row+dx[d];
                int ncol=col+dy[d];
                if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]=='1' && visited[nrow][ncol]=='0'){
                    q.offer(new coord(nrow,ncol));
                    visited[nrow][ncol]='1';
                }
            }
        }    
    }
}

class Driver {
   public static void main(String[] args) {
       Solution solution = new Solution();
       char[][] grid1 = {
           {'1', '1', '1', '1', '0'},
           {'1', '1', '0', '1', '0'},
           {'1', '1', '0', '0', '0'},
           {'0', '0', '0', '0', '0'}
       };
       System.out.println("Number of islands in grid1: " + solution.numIslands(grid1));

       char[][] grid2 = {
           {'1', '1', '0', '0', '0'},
           {'1', '1', '0', '0', '0'},
           {'0', '0', '1', '0', '0'},
           {'0', '0', '0', '1', '1'}
       };
       System.out.println("Number of islands in grid2: " + solution.numIslands(grid2));

       char[][] grid3 = {
           {'1', '0', '0', '0', '0'},
           {'0', '1', '0', '0', '0'},
           {'0', '0', '1', '0', '0'},
           {'0', '0', '0', '1', '0'}
       };
       System.out.println("Number of islands in grid3: " + solution.numIslands(grid3));
   }
}
