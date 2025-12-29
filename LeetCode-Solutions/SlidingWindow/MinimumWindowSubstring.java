
import java.util.HashMap;

/**
 * This class provides a solution to the Minimum Window Substring problem.
 * 
 * Approach: Uses a Sliding Window technique to track the minimum window that contains all characters of the target string.
 * The algorithm maintains a hashmap to store the frequency of characters in the target string and two pointers (left and right) 
 * to represent the sliding window. It expands the window to the right until all characters of the target string are included, 
 * then contracts the window from the left until a character of the target string is excluded.
 * 
 * Time Complexity: O(S + T), where S is the length of the source string and T is the length of the target string.
 * 
 * Space Complexity: O(T), where T is the length of the target string, for storing the frequency of characters in the hashmap.
 */
public class Solution {
    class Solution {
    public String minWindow(String s, String t) {
       HashMap<Character,Integer> map=new HashMap<>();
       for(int i=0;i<t.length();i++){
        map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
       }
    //    System.out.println(map);
       int rt=0;
       int lt=0;
       int minl=Integer.MAX_VALUE;
       int si=-1;
       int cnt=0;
       while(rt<s.length()){
        if(map.containsKey(s.charAt(rt)) && map.get(s.charAt(rt))>0){
        cnt++;
        }
        map.put(s.charAt(rt),map.getOrDefault(s.charAt(rt),0)-1);
        // System.out.println(map+" "+cnt);
        while(cnt==t.length()){
            if(rt-lt+1<minl){
                minl=rt-lt+1;
                si=lt;
            }
            // System.out.println(s.charAt(lt)+" "+map);
            map.put(s.charAt(lt),map.getOrDefault(s.charAt(lt),0)+1);
            // System.out.println("lt char :"+map.get(s.charAt(lt)));
            if(map.containsKey(s.charAt(lt)) && map.get(s.charAt(lt))>0){
                cnt--;
            }
            // System.out.println("cnt : "+cnt);
            lt++;
        }
        rt++;
       }
       return si==-1 ? "" : s.substring(si,si+minl);
    }
}
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));  // Output: "BANC"
        System.out.println(solution.minWindow("a", "a"));  // Output: "a"
        System.out.println(solution.minWindow("aa", "aa"));  // Output: "aa"
    }
}
