import java.util.*;
/**
 * Solution class provides method evaluate.
 * Approach: Iterate through the input string, building a map from knowledge pairs and replacing substrings within parentheses with the corresponding values or '?' if missing.
 * Time Complexity: O(n + k) where n is the length of s and k is the total length of all keys in knowledge.
 * Space Complexity: O(m) where m is the number of knowledge entries stored in the map.
 */
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != '(') {

                ans.append(s.charAt(i));
                i++;
            } else {
                int j = i + 1;

                while (s.charAt(j) != ')') {
                    j++;
                }

                String key = s.substring(i + 1, j);
                if (map.containsKey(key)) {
                    ans.append(map.get(key));
                } else {
                    ans.append("?");
                }

                // Move after ')'
                i = j + 1;
            }
        }

        return ans.toString();
    }
}
public class Driver {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<String>> knowledge1 = new ArrayList<>();
        knowledge1.add(Arrays.asList("name","bob"));
        knowledge1.add(Arrays.asList("age","30"));
        System.out.println(sol.evaluate("Hello (name), you are (age) years old.", knowledge1));
        List<List<String>> knowledge2 = new ArrayList<>();
        knowledge2.add(Arrays.asList("a","b"));
        System.out.println(sol.evaluate("(a)(b)(c)", knowledge2));
        List<List<String>> knowledge3 = new ArrayList<>();
        System.out.println(sol.evaluate("No parentheses here.", knowledge3));
    }
}
