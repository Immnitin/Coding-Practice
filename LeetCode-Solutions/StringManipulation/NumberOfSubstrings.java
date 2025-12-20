
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a solution to the problem of finding the number of substrings 
 * in a given string that contain all the characters 'a', 'b', and 'c' at least once.
 * 
 * Approach: 
 * Uses a sliding window approach with a HashMap to track the indices of the characters 'a', 'b', and 'c'. 
 * The algorithm iterates over the string, updating the indices in the HashMap and calculating the minimum index 
 * to determine the number of substrings that contain all the required characters.
 * 
 * Time Complexity: 
 * O(n), where n is the length of the input string, because each character in the string is visited once.
 * 
 * Space Complexity: 
 * O(1), because the space used does not grow with the size of the input string, as the HashMap stores a constant number of characters.
 */
class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character,Integer> map=new HashMap<>();
        // putting -1 with characters so that the index 0 doesnt be counted by default
        map.put('a',-1);
        map.put('b',-1);
        map.put('c',-1);
        int lt=0;
        int rt=0;
        int max=0;
        int cnt=0;
        while(rt<s.length()){
        int min=Integer.MAX_VALUE;
            map.put(s.charAt(rt),rt);
            if(map.get('a')!=-1 && map.get('b')!=-1 && map.get('c')!=-1)
            {min=Math.min(map.get('a'),Math.min(map.get('b'),map.get('c')));
            // {for(Map.Entry<Character,Integer> entry:map.entrySet()){
            //     min=Math.min(min,entry.getValue());
            // }
            cnt+=1+min;
            }
            rt++;
        }
        return cnt;
    }
}

public class Driver {
   public static void main(String[] args) {
      Solution solution = new Solution();
      System.out.println("Test Case 1: " + solution.numberOfSubstrings("abc"));
      System.out.println("Test Case 2: " + solution.numberOfSubstrings("aaaaaa"));
      System.out.println("Test Case 3: " + solution.numberOfSubstrings("abccba"));
   }
}
