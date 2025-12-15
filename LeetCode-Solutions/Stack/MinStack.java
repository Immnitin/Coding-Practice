import java.util.Stack;
/**
 * Approach: Uses a single stack to track both the main stack elements and the minimum value at each step.
 * The stack stores arrays of size 2, where the first element is the actual value and the second element is the minimum value up to that point.
 * Time Complexity: O(1) for push, pop, top, and getMin operations.
 * Space Complexity: O(n), where n is the number of elements pushed onto the stack.
 */
public class MinStack {
    class MinStack {
    // Stack<Integer> mainstack;
    // Stack<Integer> minstack;

    Stack<int[]> stk;
    int min=0;
    public MinStack() {
        // mainstack=new Stack<>();
        // minstack=new Stack<>();
    
        stk=new Stack<>();
    }
    
    public void push(int val) {
        // mainstack.push(val);
        // if(minstack.isEmpty() || minstack.peek()>=val){
        //     minstack.push(val);
        // }
        // min=(stk.isEmpty())? val:Math.min(stk.peek()[1],val);
        stk.push(new int[]{val,(stk.isEmpty())? val:Math.min(stk.peek()[1],val)});
    }
    
    public void pop() {
        // int num=mainstack.pop();
        // if(num==minstack.peek())   
        stk.pop();     
    }
    
    public int top() {
       return stk.peek()[0];
    }
    
    public int getMin() {
        return stk.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}

class Driver {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(5);
        obj.push(3);
        obj.push(7);
        System.out.println("Top: " + obj.top());
        System.out.println("Min: " + obj.getMin());
        obj.pop();
        System.out.println("Top after pop: " + obj.top());
        System.out.println("Min after pop: " + obj.getMin());
    }
}