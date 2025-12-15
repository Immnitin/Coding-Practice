
import java.util.Stack;

/**
 * This class provides a solution to the problem of calculating the final prices of items after discounts.
 * 
 * Approach: Uses a Stack to track indices of prices that have not yet been discounted. 
 *           It iterates through the prices array, and for each price, it checks if the top of the stack has a price 
 *           that is greater than or equal to the current price. If so, it calculates the discounted price by 
 *           subtracting the current price from the price at the top of the stack, and then pops the top of the stack.
 *           Finally, it pushes the current index onto the stack. After iterating through all prices, it calculates 
 *           the final prices for the remaining indices in the stack.
 * 
 * Time Complexity: O(n), where n is the number of prices. This is because each price is pushed and popped from the stack exactly once.
 * 
 * Space Complexity: O(n), where n is the number of prices. This is because in the worst case, the stack can contain all indices.
 */
public class Solution {
    class Solution {
    public int[] finalPrices(int[] prices) {
        int[] res=new int[prices.length];
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<prices.length;i++){
            while(!stk.isEmpty() && prices[stk.peek()]>=prices[i]){
                int curr=stk.pop();
                res[curr]=prices[curr]-prices[i];
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            int curr=stk.pop();
            res[curr]=prices[curr];
        }
        return res;
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {8, 4, 6, 2, 3},
            {1, 2, 3, 4, 5},
            {10, 20, 30, 40, 50}
        };
        for (int[] testCase : testCases) {
            int[] result = solution.finalPrices(testCase);
            System.out.println(java.util.Arrays.toString(result));
        }
    }
}
