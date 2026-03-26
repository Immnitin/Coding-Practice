import java.util.HashMap;

/**
 * Approach: Uses a HashMap to store the frequency of characters in the first string and then checks if the second string has the same characters with the same frequency.
 * Time Complexity: O(n + m) where n and m are the lengths of the two strings.
 * Space Complexity: O(n) where n is the length of the first string.
 */
public class AnagramChecker {
    class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()>t.length()){
            return false;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            if(!map.isEmpty() && !map.containsKey(a)){
                map.put(a,1);
            }
            else if(!map.isEmpty() && map.containsKey(a)){ 
                map.put(s.charAt(i),map.get(a)+1);
                // System.out.println(map);
                }
            
            else map.put(s.charAt(i),1);
        }

        for(int i=0;i<t.length();i++){
            char a=t.charAt(i);
            // System.out.println(map);
            if(!map.containsKey(a)){
                return false;
            }
            if(map.containsKey(a)){
                if(map.get(a)<=0){
                    return false;
                }
                else
                    map.put(a,map.get(a)-1);
            }
        }
        return true;
    }
}

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("listen", "silent"));  // Expected output: true
        System.out.println(solution.isAnagram("hello", "world"));  // Expected output: false
        System.out.println(solution.isAnagram("abc", "bca"));  // Expected output: true
    }
}