import java.util.Stack;
import java.util.Scanner;
/**
 * This class provides a solution to remove duplicates from a string.
 * 
 * @author [Your Name]
 * @version 1.0
 * @since [Date]
 *
 * <p>
 * Approach: Uses a Stack to track characters. It iterates over the string and pushes each character onto the stack.
 * If the top of the stack is the same as the current character, it pops the top of the stack, effectively removing the duplicate.
 * 
 * Time Complexity: O(n), where n is the length of the string, because we are doing a constant amount of work for each character in the string.
 * 
 * Space Complexity: O(n), where n is the length of the string, because in the worst case, we might have to push all characters onto the stack.
 * </p>
 */
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(!stk.isEmpty() && stk.peek()==c){
                stk.pop();
            }
            else 
                stk.push(c);
        }
        StringBuilder sb=new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("abbaca"));
        System.out.println(solution.removeDuplicates("azxxzy"));
        System.out.println(solution.removeDuplicates("aaa"));
    }
}