import java.util.HashMap;
import java.util.Map;
/**
 * Approach: Uses a Sliding Window technique with a HashMap to track the last occurrence of each character.
 * Time Complexity: O(n), where n is the length of the input string.
 * Space Complexity: O(1), as the HashMap stores a constant number of characters.
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
            {for(Map.Entry<Character,Integer> entry:map.entrySet()){
                min=Math.min(min,entry.getValue());
            }
            cnt+=1+min;
            }
            rt++;
        }
        return cnt;
    }
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSubstrings("abc"));
        System.out.println(solution.numberOfSubstrings("aaaa"));
        System.out.println(solution.numberOfSubstrings("abccba"));
    }
}