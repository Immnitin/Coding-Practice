import java.util.Arrays;
/**
 * Approach: Uses a character-by-character comparison to find the common prefix among all strings in the input array.
 * Time Complexity: O(n * m), where n is the number of strings and m is the length of the shortest string.
 * Space Complexity: O(m), where m is the length of the common prefix.
 */
public class Solution {
    class Solution {
    public String longestCommonPrefix(String[] strs) {
        String re="";
        int minlength=strs[0].length();
        for(int i=0;i<strs.length;i++){
           minlength=Math.min(minlength,strs[i].length());
        }
        StringBuilder str=new StringBuilder();
        for(int j=0;j<minlength;j++){
            char q=strs[0].charAt(j);
            int cnt=0;
            for(int p=0;p<strs.length;p++){
            if(q==strs[p].charAt(j)){
              cnt++;
            }
            }
            if(cnt==strs.length){
               str.append(q);
            }
            if(cnt!=strs.length){
              break;
            }
        }
        return str.toString();
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(solution.longestCommonPrefix(new String[] {"dog","racecar","car"}));
        System.out.println(solution.longestCommonPrefix(new String[] {"intership","interrupt","interior"}));
    }
}