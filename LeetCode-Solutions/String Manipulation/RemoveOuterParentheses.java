import java.util.Stack;
/**
 * Approach: Uses a counter to track the nesting level of parentheses. It iterates through the input string, appending characters to the result string based on the current nesting level.
 * Time Complexity: O(n), where n is the length of the input string, as it involves a single pass through the string.
 * Space Complexity: O(n), where n is the length of the input string, as in the worst case, the result string can be of the same length as the input string.
 */
public class Solution {
    class Solution {
    public String removeOuterParentheses(String s) {
        int cnt=0;
        StringBuilder sb=new StringBuilder();
        for (char c : s.toCharArray()) {
        if (c == '(') {
            if (cnt > 0) {
                sb.append(c);
            }
            cnt++;
        } else { 
            cnt--;
            if (cnt > 0) {
                sb.append(c);
            }
        }
    }
    // Stack<Character> stk=new Stack<>();
    // for(char c: s.toCharArray()){
    //     if(c=='('){
    //         if(!stk.isEmpty()){
    //             sb.append('(');
    //         }
    //         stk.push('(');
    //     }
    //     else{
    //         stk.pop();
    //         if(!stk.isEmpty())
    //         sb.append(')');
    //     }
    // }
    return sb.toString();
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeOuterParentheses("(()())(())()"));
        System.out.println(solution.removeOuterParentheses("(()())(())()()()()"));
        System.out.println(solution.removeOuterParentheses("()()()"));
    }
}