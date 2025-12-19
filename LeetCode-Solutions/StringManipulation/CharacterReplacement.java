
import java.util.HashMap;

/**
 * This class provides a solution to the character replacement problem.
 * 
 * Approach: 
 * Uses a sliding window approach to track the maximum length of a substring 
 * that can be achieved by replacing at most k characters. It maintains a hashmap 
 * to store the frequency of each character in the current window and updates 
 * the maximum length accordingly.
 * 
 * Time Complexity: 
 * O(n), where n is the length of the input string. This is because we are 
 * scanning the string once.
 * 
 * Space Complexity: 
 * O(1), as the size of the hashmap is constant (26 characters in the English 
 * alphabet).
 */
public class CharacterReplacement {
    class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(i, 0);
        }
        int lt = 0;
        int rt = 0;
        int maxlen = 0;
        int maxfreq = 0;
        int changes = 0;
        while (rt < s.length()) {
            map.put(s.charAt(rt), map.getOrDefault(s.charAt(rt), 0) + 1);
            maxfreq = Math.max(maxfreq, map.get(s.charAt(rt)));
            changes = (rt - lt + 1) - maxfreq;
            if (changes <= k) {
                maxlen = Math.max(maxlen, (rt - lt + 1));
            }
            while ((rt - lt + 1) - maxfreq > k) {
                map.put(s.charAt(lt), map.getOrDefault(s.charAt(lt), 1) - 1);
                lt++;
                // for (char i = 'A'; i <= 'Z'; i++) {
                //     maxfreq = Math.max(maxfreq, map.get(i));
                // }
            }
            rt++;
        }
        return maxlen;
    }
}

    public static class Driver {
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.characterReplacement("ABAB", 2));  // Output: 4
            System.out.println(solution.characterReplacement("AABABBA", 1));  // Output: 4
            System.out.println(solution.characterReplacement("ABC", 0));  // Output: 1
        }
    }
}
