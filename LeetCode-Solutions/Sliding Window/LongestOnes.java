
import java.util.*;

/**
 * This class provides a solution to the Longest Ones problem.
 * 
 * Approach: Uses a Sliding Window technique to track the longest subarray with at most k zeros.
 * The algorithm maintains two pointers, left and right, representing the current window.
 * It expands the window to the right and when the number of zeros exceeds k, it shrinks the window from the left.
 * 
 * Time Complexity: O(n), where n is the length of the input array.
 * Space Complexity: O(1), as it only uses a constant amount of space.
 * 
 * @author [Your Name]
 */
public class LongestOnes {
    class Solution {
    public int longestOnes(int[] nums, int k) {
        int lt=0;
        int rt=0;
        int cnt=0;
        int ml=0;
        while(rt<nums.length){
            if(nums[rt]==0){
                cnt++;
            }
            if(cnt>k){
                if(nums[lt]==0){
                    cnt--;
                }
                lt++;
            }
            ml=Math.max(ml,rt-lt+1);
            rt++;
        }
        return ml;
    }
}

    public static class Driver {
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[][] testCases = {
                {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0}
            };
            int[] ks = {2, 3, 0};
            for (int i = 0; i < testCases.length; i++) {
                int result = solution.longestOnes(testCases[i], ks[i]);
                System.out.println("Test Case " + (i + 1) + ": Longest subarray with at most " + ks[i] + " zeros: " + result);
            }
        }
    }
}
