import java.util.Arrays;
/**
 * Approach: Uses a simple iterative approach to track the maximum consecutive ones in the array.
 * Time Complexity: O(n), where n is the number of elements in the array.
 * Space Complexity: O(1), as it only uses a constant amount of space to store the count and max variables.
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int count=0;
        int max=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                count++;
                max=Math.max(count,max);
        }
        if(nums[i]==0){
            count=0;
        }
    }
    return max;
}
}
public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 0, 1},
            {0, 0, 0, 1, 1, 1}
        };
        for (int[] testCase : testCases) {
            System.out.println("Max Consecutive Ones: " + solution.findMaxConsecutiveOnes(testCase));
        }
    }
}