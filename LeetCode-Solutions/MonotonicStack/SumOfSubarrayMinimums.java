import java.util.Stack;

/**
 * Time Complexity: O(N)
 * The algorithm uses a Monotonic Stack approach (specifically, a strictly increasing stack in this implementation) 
 * to efficiently find the Previous Smaller Element (PSE) and Next Smaller Element (NSE) for every element in the array.
 * Each element is pushed onto the stack once and popped at most once, ensuring linear time complexity.
 * 
 * Space Complexity: O(N)
 * In the worst-case scenario (e.g., a strictly increasing array), the stack will hold all N indices,
 * resulting in linear space complexity.
 * 
 * Category: Monotonic Stack / Array
 */

// class Solution {
//     public int sumSubarrayMins(int[] arr) {
//         //iterate through the stack
//         //when curr>stk.peek() find nse,pse and nse*pse*curr
//         //if stk.peek()>curr find pse and then curr*curr*pse
//         int pse=0;
//         int nse=0;
//         int sum=0;
//         Stack<Integer> stk=new Stack();
//         stk.push(arr.length-1);
//         for(int i=0;i<arr.length;i++){
//             int curr=arr[i];
//             int num,j;
//             if(curr<arr[stk.peek()]){
//                 num=stk.pop();
//                 if(stk.isEmpty()){
//                     nse=arr.length;
//                 }
//                 else
//                  nse=stk.peek();
//                 for(j=i;j>=0;j--){
//                     if(arr[j]<curr){
//                         break;
//                     }
//                 }
//                 if(j==-1){
//                     pse=-1;
//                 }
//                 pse=j;
//                 sum+=num*(nse-i)*(i-pse);
//             }
//             stk.push(i);
//         }
//         if(!stk.isEmpty()){
//             pse=-1;
//             while(!stk.isEmpty()){
//                 int curr=stk.pop();
//                 if(stk.isEmpty()){
//                     nse=arr.length;
//                 }
//                 else
//                 nse=stk.peek();
//                 sum+=arr[curr]*(nse-curr)*(curr-pse);
//             }   
//         }
//         return sum;

//     }
// }

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long sum = 0;  // use long to avoid overflow
        Stack<Integer> stk = new Stack<>(); // stack stores indices

        for (int i = 0; i < n; i++) {
            // while current element is smaller than stack top
            while (!stk.isEmpty() && arr[stk.peek()] > arr[i]) {
                int idx = stk.pop();   // popped index
                int pse = stk.isEmpty() ? -1 : stk.peek(); // previous smaller
                int nse = i;           // next smaller is current index
                long left = idx - pse;
                long right = nse - idx;
                sum += (long) arr[idx] * left * right;
            }
            stk.push(i);
        }

        // handle remaining elements in stack (NSE = n)
        while (!stk.isEmpty()) {
            int idx = stk.pop();
            int pse = stk.isEmpty() ? -1 : stk.peek();
            int nse = n;   // no smaller to the right
            long left = idx - pse;
            long right = nse - idx;
            sum += (long) arr[idx] * left * right;
        }

        return (int) (sum % 1_000_000_007); // modulo as required
    }
}


public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test Case 1: Standard Example [3, 1, 2, 4]
        // Expected result: 17
        int[] arr1 = {3, 1, 2, 4};
        System.out.println("Input: [3, 1, 2, 4]");
        System.out.println("Output: " + sol.sumSubarrayMins(arr1)); 

        // Test Case 2: Longer sequence
        // Expected result: 444
        int[] arr2 = {11, 81, 94, 43, 3};
        System.out.println("
Input: [11, 81, 94, 43, 3]");
        System.out.println("Output: " + sol.sumSubarrayMins(arr2)); 

        // Test Case 3: Simple case verification [2, 3, 1]. Subarrays minimums sum to 10.
        int[] arr3 = {2, 3, 1};
        System.out.println("
Input: [2, 3, 1]");
        System.out.println("Output: " + sol.sumSubarrayMins(arr3)); 
    }
}