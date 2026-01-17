import java.util.Arrays;
/**
 * Approach: Uses a simple character array iteration to convert each uppercase character to lowercase by adding 32 to its ASCII value.
 * Time Complexity: O(n), where n is the length of the input string, because we are scanning the string once.
 * Space Complexity: O(n), where n is the length of the input string, because we are creating a character array of the same length as the input string.
 */
public class Solution {
    class Solution {
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return new String(chars);
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.toLowerCase("Hello World"));
        System.out.println(solution.toLowerCase("ALL CAPS"));
        System.out.println(solution.toLowerCase("Mixed Case"));
    }
}