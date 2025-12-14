import java.lang.Math;
/**
 * Approach: Uses the built-in Math.sqrt function to calculate the square root of a given number.
 * Time Complexity: O(1) because it involves a constant time operation.
 * Space Complexity: O(1) because it uses a constant amount of space.
 */
class Solution {
    public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }
}
public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(4));  // Expected output: 2
        System.out.println(solution.mySqrt(8));  // Expected output: 2
        System.out.println(solution.mySqrt(9));  // Expected output: 3
    }
}