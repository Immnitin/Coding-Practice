
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * This class provides a solution to the Max Sliding Window problem.
 * 
 * Approach: Uses a Monotonic Deque to track indices of the maximum elements in the current window.
 * The deque stores indices in a way that the front of the deque always contains the index of the maximum element in the current window.
 * 
 * Time Complexity: O(n), where n is the number of elements in the input array.
 * This is because each element is pushed and popped from the deque exactly once.
 * 
 * Space Complexity: O(n), where n is the number of elements in the input array.
 * This is because in the worst case, the deque can store up to n elements.
 */
public class Solution {
    class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        int[] res;
        if(nums.length<k){
            res=new int[nums.length];
        }
        else
         res=new int[nums.length-(k-1)];
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1 && cnt<res.length){
                res[cnt]=nums[dq.peekFirst()];
                cnt++;
            }
        }
        return res;
    }
}
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] result1 = solution.maxSlidingWindow(nums1, k1);
        System.out.println("Test case 1 result: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Test case 2
        int[] nums2 = {1, 2, 3, 4, 5};
        int k2 = 2;
        int[] result2 = solution.maxSlidingWindow(nums2, k2);
        System.out.println("Test case 2 result: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Test case 3
        int[] nums3 = {9, 11};
        int k3 = 2;
        int[] result3 = solution.maxSlidingWindow(nums3, k3);
        System.out.println("Test case 3 result: ");
        for (int num : result3) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
