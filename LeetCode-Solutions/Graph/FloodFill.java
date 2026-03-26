
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class provides a solution to the flood fill problem.
 * 
 * Approach: Uses a Breadth-First Search (BFS) algorithm to traverse the image and fill the connected pixels with the same color.
 * Time Complexity: O(M * N), where M is the number of rows and N is the number of columns in the image.
 * Space Complexity: O(M * N), where M is the number of rows and N is the number of columns in the image.
 */
class Solution {
    class coord {
        int st, sc;

        public coord(int st, int sc) {
            this.st = st;
            this.sc = sc;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int[][] visited = new int[image.length][image[0].length];
        Queue<coord> q = new LinkedList<>();

        int scol = image[sr][sc];
        image[sr][sc] = color;

        q.offer(new coord(sr, sc));
        visited[sr][sc] = 1;

        int[] xd = { -1, 0, 1, 0 };
        int[] yd = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {

            coord rc = q.poll();
            int r = rc.st;
            int c = rc.sc;

            visited[r][c] = 1;

            for (int i = 0; i < xd.length; i++) {
                int nrow = r + xd[i];
                int ncol = c + yd[i];

                if (nrow >= 0 && nrow < image.length && ncol >= 0 && ncol < image[0].length) {
                    if (image[nrow][ncol] == scol && visited[nrow][ncol] == 0) {
                        q.offer(new coord(nrow, ncol));
                        image[nrow][ncol] = color;
                        visited[nrow][ncol] = 1;
                    }
                }

            }
        }
        return image;
    }

}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[][] image1 = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr1 = 1;
        int sc1 = 1;
        int color1 = 2;
        int[][] result1 = solution.floodFill(image1, sr1, sc1, color1);
        System.out.println("Test case 1 result:");
        for (int[] row : result1) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
        
        // Test case 2
        int[][] image2 = {
            {0, 0, 0},
            {0, 1, 1}
        };
        int sr2 = 1;
        int sc2 = 1;
        int color2 = 1;
        int[][] result2 = solution.floodFill(image2, sr2, sc2, color2);
        System.out.println("Test case 2 result:");
        for (int[] row : result2) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
        
        // Test case 3
        int[][] image3 = {
            {0, 0, 0},
            {0, 0, 0}
        };
        int sr3 = 0;
        int sc3 = 0;
        int color3 = 2;
        int[][] result3 = solution.floodFill(image3, sr3, sc3, color3);
        System.out.println("Test case 3 result:");
        for (int[] row : result3) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
