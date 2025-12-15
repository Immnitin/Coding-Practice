import java.util.Stack;
/**
 * Approach: Uses a Stack to evaluate the Reverse Polish Notation. The algorithm iterates over each token in the input array. If the token is an operator, it pops two numbers from the stack, applies the operation, and pushes the result back onto the stack. If the token is a number, it simply pushes the number onto the stack.
 * Time Complexity: O(n), where n is the number of tokens in the input array, since we process each token exactly once.
 * Space Complexity: O(n), where n is the number of tokens in the input array, since in the worst case, we might need to push all tokens onto the stack.
 */
public class Solution {
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
                case '/':
                {System.out.println(a+" "+b+" "+b/a);
                stk.push(b/a);break;}}
            }
else stk.push(Integer.parseInt(tokens[i]));
        }
        System.out.println(stk);
        return stk.pop();
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"})); // Expected output: 9
        System.out.println(solution.evalRPN(new String[]{"4", "13", "5", "/", "+"})); // Expected output: 6
        System.out.println(solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"})); // Expected output: 22
    }
}