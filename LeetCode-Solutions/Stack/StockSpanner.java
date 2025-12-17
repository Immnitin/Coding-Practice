import java.util.Stack;
/**
 * Approach: Uses a Stack to track the stock prices and their corresponding spans. The stack stores arrays of two integers, where the first integer is the price and the second integer is the span. The next method pops all the prices from the stack that are less than or equal to the current price and adds their spans to the current span.
 * Time Complexity: O(n), where n is the number of calls to the next method. In the worst case, each call to next might pop all the previous elements from the stack, resulting in a total of n operations across all calls.
 * Space Complexity: O(n), where n is the number of calls to the next method. In the worst case, the stack might store n elements.
 */
class StockSpanner {
    Stack<int[]> stk;
    public StockSpanner() {
    stk=new Stack<>();      
    }
    
    public int next(int price) {
        int span=1;
        while(!stk.isEmpty() && stk.peek()[0]<=price){
            span+=stk.pop()[1];
        }
        stk.push(new int[]{price,span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

class Driver {
    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100)); // Output: 1
        System.out.println(obj.next(80));  // Output: 1
        System.out.println(obj.next(60));  // Output: 1
        System.out.println(obj.next(70));  // Output: 2
        System.out.println(obj.next(60));  // Output: 1
        System.out.println(obj.next(75));  // Output: 4
        System.out.println(obj.next(85));  // Output: 6
    }
}