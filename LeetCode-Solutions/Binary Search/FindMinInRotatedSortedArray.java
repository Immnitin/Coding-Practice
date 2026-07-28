import java.util.Arrays;

/**
 * Approach: Uses a Binary Search algorithm to find the minimum element in a rotated sorted array.
 * The idea is to find the pivot element where the rotation occurs, and then determine which half of the array the minimum element is in.
 * Time Complexity: O(log n), where n is the number of elements in the array.
 * Space Complexity: O(1), as only a constant amount of space is used.
 */
public class Solution {
    class Solution {
    public int findMin(int[] nums) {
        // int st=0;
        // int ed=nums.length-1;
        // if(nums.length==2){
        //     if(nums[0]>nums[1]){
        //         return nums[1];
        //     }
        //     else 
        //         return nums[0];
        // }
        // while(st<ed){
        //     int mid=st+(ed-st)/2;
        //     if(mid-1>=0){
        //     if(nums[mid]<nums[mid-1]){
        //         return nums[mid];
        //     }
        //     }
        //     if(mid+1<nums.length){
        //     if(nums[mid]>nums[mid+1]){
        //         return nums[mid+1];
        //     }
        //     }
        //     if(nums[mid]>nums[nums.length-1]){
        //         st=mid+1;
        //     }
        //     else if(nums[mid]<nums[nums.length-1]){
        //         ed=mid-1;
        //     }
        // }
        // return nums[0];

        int st=0;
        int ed=nums.length-1;

        while(st!=ed){
            int mid=(st+ed)/2;
            if(nums[mid]>nums[ed]){
                st=mid+1;
            }
            else {
                ed=mid;
            }
        }
        return nums[st];

    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {3, 4, 5, 1, 2},
            {4, 5, 6, 7, 0, 1, 2},
            {11, 13, 15, 17}
        };
        for (int[] testCase : testCases) {
            System.out.println("Minimum element in array " + Arrays.toString(testCase) + " is: " + solution.findMin(testCase));
        }
    }
}