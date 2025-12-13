import java.util.Arrays;

/**
 * Problem: Merge Sorted Array
 * 
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * The user's solution uses the technique of merging from the end of the arrays to perform
 * the operation in-place without needing extra space or overwriting elements prematurely.
 * 
 * Time Complexity: O(m + n)
 * The algorithm uses the two-pointer approach, starting from the end of both arrays (m and n being the lengths of the non-zero parts).
 * Since every element is checked and moved at most once, the time complexity is linear 
 * with respect to the total number of elements being merged (m + n).
 * 
 * Space Complexity: O(1)
 * The merging is performed entirely in-place within the nums1 array. No auxiliary data structures 
 * are used whose size scales with the input size.
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(j>=0){
            if(i>=0 && nums1[i]>=nums2[j]){
                nums1[k]=nums1[i];
                i--;
                k--;
            }
            else
            {nums1[k]=nums2[j];
            j--;
            k--;}
        }
    }
}

class Driver {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test Case 1: Standard merge
        int[] nums1_1 = {1, 2, 3, 0, 0, 0};
        int m1 = 3;
        int[] nums2_1 = {2, 5, 6};
        int n1 = 3;
        sol.merge(nums1_1, m1, nums2_1, n1);
        System.out.println("Test Case 1 (nums1={1, 2, 3, 0, 0, 0}, nums2={2, 5, 6}) ");
        System.out.println("  Expected: [1, 2, 2, 3, 5, 6]\n  Actual: " + Arrays.toString(nums1_1));

        // Test Case 2: nums2 elements smaller than nums1 elements (requires full copy of nums2)
        int[] nums1_2 = {4, 5, 6, 0, 0, 0};
        int m2 = 3;
        int[] nums2_2 = {1, 2, 3};
        int n2 = 3;
        sol.merge(nums1_2, m2, nums2_2, n2);
        System.out.println("\nTest Case 2 (nums1={4, 5, 6, 0, 0, 0}, nums2={1, 2, 3}) ");
        System.out.println("  Expected: [1, 2, 3, 4, 5, 6]\n  Actual: " + Arrays.toString(nums1_2));

        // Test Case 3: nums1 is initially empty (m=0)
        int[] nums1_3 = {0, 0, 0};
        int m3 = 0;
        int[] nums2_3 = {7, 8, 9};
        int n3 = 3;
        sol.merge(nums1_3, m3, nums2_3, n3);
        System.out.println("\nTest Case 3 (nums1={0, 0, 0}, nums2={7, 8, 9}) ");
        System.out.println("  Expected: [7, 8, 9]\n  Actual: " + Arrays.toString(nums1_3));
    }
}