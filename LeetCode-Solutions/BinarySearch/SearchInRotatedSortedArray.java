import java.util.Arrays;

/**
 * Approach: Uses a modified Binary Search algorithm to find the target element in a rotated sorted array.
 * The algorithm first checks if the array has only one element, then it proceeds with the binary search.
 * If the middle element is equal to the target, it returns true. If the start and middle elements are equal, it skips the duplicate elements.
 * It then decides which half to continue the search in based on the comparison of the target with the start and middle elements.
 * 
 * Time Complexity: O(log n) in the best case when there are no duplicates, O(n) in the worst case when all elements are the same.
 * Space Complexity: O(1) as it only uses a constant amount of space.
 */
public class Solution {
    class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length==1){
            if(nums[0]==target){
                return true;
            }
            else return false;
        }
        return bs(nums,target,0,nums.length-1);
    }
    public boolean bs(int[] nums,int target, int st, int ed){
        if(st>=ed){
            return false;
        }

        int mid=(st+ed)/2;

        // System.out.println(nums[mid]);

        if(nums[mid]==target){
            return true;
        }

        if(nums[st]==nums[mid] && nums[mid]==nums[ed]){
            st++;
            ed--;
            return bs(nums,target,st,ed);
        }

        if(nums[st]==target || nums[mid]==target || nums[ed]==target){
            return true;
        }

        if(nums[st]<=nums[mid]){
            if(target>nums[st] && nums[mid]>target){
                return bs(nums,target,st,mid-1);
            }
            else
                return bs(nums,target,mid+1,ed);

        }
        if(nums[mid]<=nums[ed]){
            if(target>nums[mid] && nums[ed]>target){
                return bs(nums,target,mid+1,ed);
            }
            else
            return bs(nums,target,st,mid-1);
        }

        return false;
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {2, 5, 6, 0, 0, 1, 2},
            {0, 0, 1, 2, 2, 5, 6},
            {1, 3}
        };
        int[] targets = {0, 0, 3};
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ": " + solution.search(testCases[i], targets[i]));
        }
    }
}