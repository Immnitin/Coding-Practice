import java.util.Arrays;
/**
 * Approach: Uses a simple iterative binary search approach to find the position where the target element should be inserted to maintain sorted order.
 * Time Complexity: O(n) in the worst case when the target is larger than all elements in the array.
 * Space Complexity: O(1) as it only uses a constant amount of space.
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i;
        for(i=0;i<nums.length;i++){
            if(nums[i]>=target){
                break;
            }
        }
        return i;
    }
}
public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {1, 3, 5, 6},
            {1, 3, 5, 6, 8},
            {1}
        };
        int[] targets = {5, 7, 1};
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ": Target = " + targets[i] + ", Array = " + Arrays.toString(testCases[i]) + ", Result = " + solution.searchInsert(testCases[i], targets[i]));
        }
    }
}