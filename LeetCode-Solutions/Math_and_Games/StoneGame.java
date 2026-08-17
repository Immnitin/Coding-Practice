import java.util.Arrays;
/**
 * Approach: This solution assumes that the first player can always win by choosing the larger pile at each turn.
 * Time Complexity: O(1) because the function always returns true without any loops or recursive calls.
 * Space Complexity: O(1) because the function uses a constant amount of space.
 */
class Solution {
    public boolean stoneGame(int[] piles) {
        return true;
    }
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {{5, 3, 4, 5}, {3, 7, 2, 3}, {1, 2, 3, 4, 5}};
        for (int[] testCase : testCases) {
            System.out.println("Input: " + Arrays.toString(testCase) + ", Output: " + solution.stoneGame(testCase));
        }
    }
}