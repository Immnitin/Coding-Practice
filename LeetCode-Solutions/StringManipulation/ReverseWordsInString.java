import java.util.Arrays;
/**
 * Approach: Uses a StringBuilder to reverse each word in the input string.
 * Time Complexity: O(n*m) where n is the number of words and m is the maximum length of a word.
 * Space Complexity: O(n*m) for storing the result.
 */
class Solution {
    public String reverseWords(String s) {
        String[] str=s.split(" ");
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<str.length-1;i++){
            StringBuilder sb=new StringBuilder(str[i]);
            sb.reverse();
            ans.append(sb+" ");
        }
        StringBuilder sbs=new StringBuilder(str[str.length-1]);
        sbs.reverse();
        ans.append(sbs);
        return ans.toString();
       
    }
}
public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("Hello World"));
        System.out.println(solution.reverseWords("I am a programmer"));
        System.out.println(solution.reverseWords("This is a test"));
    }
}