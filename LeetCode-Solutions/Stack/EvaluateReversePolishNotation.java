import java.util.Stack;
/**
 * Approach: Uses a Stack to evaluate the Reverse Polish Notation. It iterates over the tokens, pushing numbers onto the stack and popping the top two elements when an operator is encountered. The result of the operation is then pushed back onto the stack.
 * Time Complexity: O(n), where n is the number of tokens. This is because we are doing a constant amount of work for each token.
 * Space Complexity: O(n), where n is the number of tokens. This is because in the worst case, we might have to push all tokens onto the stack.
 */
class Solution {
    public int evalRPN(String[] tokens) {
        String opr="+-*/";
        String nums="1234567890";
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(opr.contains(tokens[i])){
                char op=tokens[i].charAt(0);
                int a=stk.pop();
                int b=(stk.isEmpty())? 0:stk.pop();
                switch (op){
                case '+': stk.push(a+b);break;
                case '-': stk.push(b-a);break;
                case '*':stk.push(a*b);break;
                case '/':stk.push(b/a);break;
            }
            }
             else stk.push(Integer.parseInt(tokens[i]));
    }
        return stk.pop();

    }}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"})); // Expected output: 9
        System.out.println(solution.evalRPN(new String[]{"4", "13", "5", "/", "+"})); // Expected output: 6
        System.out.println(solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"})); // Expected output: 22
    }
}