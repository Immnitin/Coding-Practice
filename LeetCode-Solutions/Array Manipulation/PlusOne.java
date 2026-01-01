import java.util.Arrays;
/**
 * Approach: This solution uses a simple iterative approach to increment the given array of digits by one. It starts from the end of the array and checks each digit. If the digit is less than 9, it increments the digit and returns the array. If the digit is 9, it sets the digit to 0 and continues to the next digit. If all digits are 9, it creates a new array with an additional digit and sets the first digit to 1.
 * Time Complexity: O(n), where n is the number of digits in the array.
 * Space Complexity: O(n), where n is the number of digits in the array. In the worst case, a new array of size n+1 is created.
 */
public class Solution {
    class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}

}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {1, 2, 3},
            {4, 3, 2, 1},
            {9, 9, 9}
        };
        for (int[] testCase : testCases) {
            int[] result = solution.plusOne(testCase);
            System.out.println("Input: " + Arrays.toString(testCase) + ", Output: " + Arrays.toString(result));
        }
    }
}