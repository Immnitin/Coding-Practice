import java.util.Stack;

/**
 * Solution for the Sum of Subarray Ranges problem (LeetCode 2104).
 *
 * The approach leverages the Monotonic Stack pattern to calculate the contribution of each element
 * (arr[i]) as the maximum element across all subarrays containing it (Sum Maxima), and as the
 * minimum element across all subarrays containing it (Sum Minima).
 * The total range sum is calculated as (Sum Maxima) - (Sum Minima).
 *
 * Time Complexity: O(N)
 * Both helper functions, submaxsum and subminsum, iterate through the array once (or use a monotonic stack
 * where each element is pushed and popped at most once), resulting in linear time complexity.
 *
 * Space Complexity: O(N)
 * Due to the use of the Stack data structure to store indices during the monotonic stack operations.
 */

class Solution {
    public long subArrayRanges(int[] nums) {
      long max=submaxsum(nums);
      long min=subminsum(nums);  
      return max-min;
    }
    public long submaxsum(int[] arr){
        long MOD=(long)1e9^7;
        long sum=0;
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!stk.isEmpty() && arr[i]>arr[stk.peek()]){
                int curr=stk.pop();
                int nge=i;
                int pge=(stk.isEmpty()) ? -1: stk.peek();
                int left=curr-pge;
                int right=nge-curr;
                sum = (sum + (long)arr[curr] * left * right);                
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            int curr=stk.pop();
            int nge=arr.length;
            int pge=(stk.isEmpty()) ? -1: stk.peek();
            int left=curr-pge;
            int right=nge-curr;
            sum = (sum + (long)arr[curr] * left * right);
        }
        return sum;
    }
    public long subminsum(int[] arr){
        long MOD=(long)1e9^7;
        long sum=0;
        Stack<Integer> stk=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!stk.isEmpty() &&  arr[stk.peek()]>arr[i]){
                int curr=stk.pop();
                int pse=i;
                int nse=(stk.isEmpty())?arr.length:stk.peek();
                int left=curr-pse;
                int right=nse-curr;
                sum = (sum + (long)arr[curr] * left * right);
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            int curr=stk.pop();
            int pse=-1;
            int nse=(stk.isEmpty())? arr.length : stk.peek();
            int left=curr-pse;
            int right=nse-curr;
            sum = (sum + (long)arr[curr] * left * right);
        }
        return sum;
    }
}

class Driver {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Standard increasing array
        int[] nums1 = {1, 2, 3};
        long result1 = sol.subArrayRanges(nums1);
        // Expected Maxima Sum: (1*1*3 + 2*2*2 + 3*3*1) = 3 + 8 + 9 = 20
        // Expected Minima Sum: (1*3*1 + 2*2*2 + 3*1*3) = 3 + 8 + 9 = 20 (Mistake here, using standard sums)
        // Actual Sum Maxima (from LC calculation): 20
        // Actual Sum Minima (from LC calculation): 16 (1: 1*1*3, 2: 2*2*2, 3: 3*3*1. Wait, this is wrong. Let's use known answer)
        // Known Answer: 4
        System.out.println("Test Case 1: [1, 2, 3]");
        System.out.println("Output: " + result1 + " | Expected: 4");
        assert result1 == 4 : "Test 1 Failed";

        // Test Case 2: Array with negative and varied numbers
        int[] nums2 = {4, -2, 1};
        long result2 = sol.subArrayRanges(nums2);
        // Known Answer: 15
        System.out.println("\nTest Case 2: [4, -2, 1]");
        System.out.println("Output: " + result2 + " | Expected: 15");
        assert result2 == 15 : "Test 2 Failed";

        // Test Case 3: Array with duplicates
        int[] nums3 = {1, 3, 3};
        long result3 = sol.subArrayRanges(nums3);
        // Known Answer: 4
        System.out.println("\nTest Case 3: [1, 3, 3]");
        System.out.println("Output: " + result3 + " | Expected: 4");
        assert result3 == 4 : "Test 3 Failed";
    }
}