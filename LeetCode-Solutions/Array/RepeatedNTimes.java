import java.util.Arrays;
/**
 * Approach: This solution uses a simple iterative approach to find the repeated element in the array. It checks each element with its next two elements to find the repeated one. If not found, it checks the first and last elements for arrays of length less than or equal to 4.
 * Time Complexity: O(n), where n is the number of elements in the array.
 * Space Complexity: O(1), as it only uses a constant amount of space.
 */
public class Solution {
    class Solution {
    public int repeatedNTimes(int[] nums) {
        int i;
        
        for( i=0;i<nums.length-2;i++){
            if(nums[i]==nums[i+1] || nums[i]==nums[i+2]){
                return nums[i];
            }
        }
        if(nums.length<=4){
            if(nums[0]==nums[nums.length-1]){
                return nums[0];
            }
        }
        return nums[i];
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 3};
        int[] nums2 = {2, 1, 2, 5, 3, 2};
        int[] nums3 = {2, 2, 2, 2};
        System.out.println("Repeated element in nums1: " + solution.repeatedNTimes(nums1));
        System.out.println("Repeated element in nums2: " + solution.repeatedNTimes(nums2));
        System.out.println("Repeated element in nums3: " + solution.repeatedNTimes(nums3));
    }
}