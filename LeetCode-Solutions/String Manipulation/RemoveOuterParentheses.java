
import java.util.Stack;

/**
 * This class provides a solution to the problem of removing outer parentheses from a given string.
 * 
 * Approach: Uses a Stack to track the opening parentheses. It iterates over the string, pushing opening parentheses onto the stack and popping them when a closing parenthesis is encountered. 
 *           If the stack is not empty when an opening parenthesis is encountered, it is added to the result string. Similarly, if the stack is not empty when a closing parenthesis is encountered, 
 *           it is added to the result string after popping the corresponding opening parenthesis from the stack.
 * 
 * Time Complexity: O(n), where n is the length of the input string, as we are scanning the string once.
 * 
 * Space Complexity: O(n), where n is the length of the input string, as in the worst case, we might need to store all characters in the stack.
 */
public class Solution {
    class Solution {
    public String removeOuterParentheses(String s) {
        int cnt=0;
        StringBuilder sb=new StringBuilder();
    //     for (char c : s.toCharArray()) {
    //     if (c == '(') {
    //         if (cnt > 0) {
    //             sb.append(c);
    //         }
    //         cnt++;
    //     } else { 
    //         cnt--;
    //         if (cnt > 0) {
    //             sb.append(c);
    //         }
    //     }
    // }
    Stack<Character> stk=new Stack<>();
    for(char c: s.toCharArray()){
        if(c=='('){
            if(!stk.isEmpty()){
                sb.append('(');
            }
            stk.push('(');
        }
        else{
            stk.pop();
            if(!stk.isEmpty())
            sb.append(')');
        }
    }
    return sb.toString();
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeOuterParentheses("(()())(())()"));  // Output: "()()()()"
        System.out.println(solution.removeOuterParentheses("(()())(())()()()()"));  // Output: "()()()()()()()"
        System.out.println(solution.removeOuterParentheses("()()()"));  // Output: """
    }
}
