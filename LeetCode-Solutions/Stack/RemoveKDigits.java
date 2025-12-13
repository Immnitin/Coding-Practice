import java.util.Stack;

/**
 * Solution for the Remove K Digits problem using a Monotonic Stack (Greedy approach).
 * 
 * Time Complexity: O(N), where N is the length of the input string 'num'.
 * Each digit is pushed onto the stack exactly once and popped at most once,
 * ensuring linear time processing. The final reconstruction steps (reversing,
 * trimming zeros) also take O(N).
 * 
 * Space Complexity: O(N).
 * The auxiliary stack stores up to N digits in the worst case.
 */
class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<num.length();i++){
            int curr=num.charAt(i)-'0';
            while(!stk.isEmpty() && k>0 && stk.peek()>curr){
                stk.pop();
                k--;
            }
            stk.push(num.charAt(i)-'0');
        }
        while(k>0 && !stk.isEmpty()){
            stk.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0') {
    sb.deleteCharAt(0);
}
if (sb.length() == 0) return "0";
        return sb.toString();
    }
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard removal using monotonic stack logic
        String num1 = "1432219";
        int k1 = 3;
        String result1 = solution.removeKdigits(num1, k1);
        System.out.println("Input: num=\"" + num1 + "\", k=" + k1 + " | Result: " + result1 + " | Expected: 1219");

        // Test Case 2: Handling leading zeros and minimal remaining k removal
        String num2 = "10200";
        int k2 = 1;
        String result2 = solution.removeKdigits(num2, k2);
        System.out.println("Input: num=\"" + num2 + "\", k=" + k2 + " | Result: " + result2 + " | Expected: 200");

        // Test Case 3: Complete removal edge case
        String num3 = "10";
        int k3 = 2;
        String result3 = solution.removeKdigits(num3, k3);
        System.out.println("Input: num=\"" + num3 + "\", k=" + k3 + " | Result: " + result3 + " | Expected: 0");

        // Test Case 4: Removing digits from a descending sequence (requires final k removal)
        String num4 = "98765";
        int k4 = 2;
        String result4 = solution.removeKdigits(num4, k4);
        System.out.println("Input: num=\"" + num4 + "\", k=" + k4 + " | Result: " + result4 + " | Expected: 765");
    }
}