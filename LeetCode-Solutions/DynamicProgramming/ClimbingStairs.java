
import java.util.*;

/**
 * This class provides a solution to the Climbing Stairs problem.
 * 
 * Approach: Uses Dynamic Programming to store and reuse the results of subproblems.
 *           The problem is solved by maintaining a running sum of the number of ways to reach the previous two steps.
 * Time Complexity: O(n), where n is the number of stairs.
 * Space Complexity: O(1), as only a constant amount of space is used to store the previous two steps.
 */
public class ClimbingStairs {
    class Solution {
    
    public int climbStairs(int n) {
      int[] dp=new int[n+1];
      int prev=1;
      int prev2=1;
      int curr=1;
      for(int i=2;i<=n;i++){
            curr=prev+prev2;
            prev2=prev;
            prev=curr;
      }
      return curr;
    }
}
}

class Driver {
    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        System.out.println("Test Case 1: " + solution.climbStairs(2));  // Expected output: 2
        System.out.println("Test Case 2: " + solution.climbStairs(3));  // Expected output: 3
        System.out.println("Test Case 3: " + solution.climbStairs(4));  // Expected output: 5
    }
}
