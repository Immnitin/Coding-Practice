
import java.util.Arrays;

/**
 * This class provides a solution to the problem of assigning cookies to children based on their greed factor and cookie size.
 * 
 * Approach: Uses a greedy algorithm to sort both the greed factors and cookie sizes, then iterates through the sorted arrays to assign cookies.
 * Time Complexity: O(n log n + m log m) due to the sorting of the greed factors and cookie sizes, where n is the number of children and m is the number of cookies.
 * Space Complexity: O(1) if the input arrays are allowed to be modified in-place, otherwise O(n + m) for the sorted arrays.
 */
public class Solution {
    class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt=0;
       int lt=0;
       int rt=0;
       while(lt<s.length && rt<g.length){
        if(g[rt]<=s[lt]){
            cnt++;
            rt++;
        }
        lt++;
        // System.out.println("lt "+lt+" rt "+rt+" cnt "+cnt);
       }
       return cnt;
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {1, 2, 3}, {1, 1},
            {1, 2}, {1, 2, 3},
            {1, 2, 3}, {3, 4, 5}
        };
        for (int i = 0; i < testCases.length; i += 2) {
            int[] g = testCases[i];
            int[] s = testCases[i + 1];
            System.out.println("Test Case " + (i / 2 + 1) + ": Assigning cookies to children with greed factors " + Arrays.toString(g) + " and cookie sizes " + Arrays.toString(s));
            System.out.println("Number of children that can be satisfied: " + solution.findContentChildren(g, s));
        }
    }
}