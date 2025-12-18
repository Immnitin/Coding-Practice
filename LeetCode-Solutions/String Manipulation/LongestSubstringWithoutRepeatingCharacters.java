import java.util.HashSet;

/**
 * This class provides a solution to the problem of finding the length of the longest substring without repeating characters.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class Solution {
    /**
     * Returns the length of the longest substring without repeating characters.
     * 
     * Approach: Uses a sliding window approach with a HashSet to track unique characters in the current substring.
     * Time Complexity: O(n), where n is the length of the input string, because each character is visited at most twice.
     * Space Complexity: O(min(n, m)), where m is the size of the character set, because in the worst case, the HashSet will store all unique characters in the string.
     * 
     * @param s the input string
     * @return the length of the longest substring without repeating characters
     */
    import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    // public static void main(String[] args) {
    // String s = "ohomm";
    // Solution solution = new Solution();
    // System.out.println(solution.lengthOfLongestSubstring(s)); // Outputs: 3
    // }
}

}

/**
 * Driver class to test the Solution class.
 */
public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("ohomm")); // Outputs: 3
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // Outputs: 3
        System.out.println(solution.lengthOfLongestSubstring("bbbbb")); // Outputs: 1
    }
}