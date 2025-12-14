
import java.util.Stack;

/**
 * This class provides a solution to the Largest Rectangle Area problem.
 * 
 * Approach: Uses a Stack to track indices of the histogram bars. The stack is used to keep track of the indices of the bars. 
 *           We start scanning the histogram from left to right. If the current bar is higher than or equal to the bar at the top of the stack, 
 *           we push its index to the stack. If the current bar is lower than the bar at the top of the stack, we calculate the area of the rectangle 
 *           with the bar at the top of the stack as the smallest bar.
 * Time Complexity: O(n), where n is the number of bars in the histogram.
 * Space Complexity: O(n), where n is the number of bars in the histogram.
 */
public class Solution {
    class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==1){
            return heights[0];
        }
        Stack<Integer> stk=new Stack<>();
        int max=0;
        for(int i=0;i<heights.length;i++){
            while(!stk.isEmpty()&& heights[i]<heights[stk.peek()]){
                int curr=stk.pop();
                int nse=i;
                int pse=(stk.isEmpty())? -1: stk.peek();
                int area=heights[curr]*(nse-pse-1);
                max=Math.max(max,area);
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            int curr=stk.pop();
            int nse=heights.length;
            int pse=(stk.isEmpty())? -1: stk.peek();
            int area=heights[curr]*(nse-pse-1);
            max=Math.max(max,area); 
        }
        return max;
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {2,1,5,6,2,3},
            {2},
            {1, 2, 3, 4, 5}
        };
        for (int[] testCase : testCases) {
            System.out.println("Largest Rectangle Area: " + solution.largestRectangleArea(testCase));
        }
    }
}
