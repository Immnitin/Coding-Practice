
import java.util.HashMap;

/**
 * This class provides a solution to the problem of counting the number of jewels in a given string of stones.
 * 
 * Approach: Uses a HashMap to store the frequency of each stone, then iterates over the jewels string to count the total number of jewels.
 * Time Complexity: O(J + S), where J is the length of the jewels string and S is the length of the stones string.
 * Space Complexity: O(S), where S is the length of the stones string.
 */
public class Solution {
    class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int cnt=0;
       HashMap<Character,Integer> map=new HashMap<>();
       for(int i=0;i<stones.length();i++){
        if(!map.containsKey(stones.charAt(i))){
            map.put(stones.charAt(i),1);
        }
        else
        map.put(stones.charAt(i),map.getOrDefault(stones.charAt(i),1)+1);
       }
       for(int i=0;i<jewels.length();i++){
        cnt+=map.containsKey(jewels.charAt(i))? map.get(jewels.charAt(i)):0;
       }
        return cnt;
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numJewelsInStones("aA", "aAAbbbb"));  // Expected output: 3
        System.out.println(solution.numJewelsInStones("z", "ZZ"));  // Expected output: 0
        System.out.println(solution.numJewelsInStones("aBb", "aabBc"));  // Expected output: 3
    }
}
