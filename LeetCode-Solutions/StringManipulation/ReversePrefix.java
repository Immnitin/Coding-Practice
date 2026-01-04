import java.lang.StringBuilder;
/**
 * Approach: Uses a StringBuilder to reverse the prefix of a given string.
 * Time Complexity: O(n), where n is the length of the string.
 * Space Complexity: O(n), where n is the length of the string.
 */
class Solution {
    public String reversePrefix(String s, int k) {
        StringBuilder sb=new StringBuilder(s.substring(0,k));
        sb.reverse();
        return sb.toString()+s.substring(k);
    }
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reversePrefix("abcd", 2)); // Expected output: "bacd"
        System.out.println(solution.reversePrefix("abcd", 3)); // Expected output: "cbad"
        System.out.println(solution.reversePrefix("abcd", 4)); // Expected output: "dcba"
    }
}