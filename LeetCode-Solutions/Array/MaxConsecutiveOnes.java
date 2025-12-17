import java.util.Arrays;
/**
 * Approach: This solution uses a simple iterative approach to find the maximum consecutive ones in the given array.
 * It iterates through the array and keeps track of the current count of consecutive ones and the maximum count found so far.
 * 
 * Time Complexity: O(n), where n is the number of elements in the array.
 * Space Complexity: O(1), as it uses a constant amount of space to store the count and max variables.
 */
public class Solution {
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
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 0, 1},
            {0, 0, 0, 1, 1, 1}
        };
        for (int[] testCase : testCases) {
            System.out.println("Max consecutive ones: " + solution.findMaxConsecutiveOnes(testCase));
        }
    }
}