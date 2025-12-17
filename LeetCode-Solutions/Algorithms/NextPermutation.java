import java.util.Arrays;

/**
 * This class generates the next lexicographically greater permutation of a given array of integers.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class NextPermutation {
    /**
     * Generates the next lexicographically greater permutation of a given array of integers.
     * 
     * Approach: Uses a two-pointer technique to find the pivot element and the minimum greater element to its right.
     *            If no such pair is found, the array is sorted in ascending order.
     * Time Complexity: O(n) where n is the number of elements in the array.
     * Space Complexity: O(1) as only a constant amount of space is used.
     * 
     * @param nums the input array of integers
     */
    class Solution {
    public void nextPermutation(int[] nums) {
        int pivot=0;
        int pidx=0;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                pidx=i-1;
                pivot=nums[i-1];
                break;
            }
        }
        int min_pivot=0;
        int i;
        for(i=nums.length-1;i>0;i--){
           if(pivot<nums[i]){
            min_pivot=i;
            break;
           }
        }
           if(i==0){
            Arrays.sort(nums);
            return;
           } 
        int temp=nums[pidx];
        nums[pidx]=nums[min_pivot];
        nums[min_pivot]=temp;
        Arrays.sort(nums,pidx+1,nums.length);
    }
}

    public static class Driver {
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[][] testCases = {
                {1, 2, 3},
                {3, 2, 1},
                {1, 1, 5}
            };
            for (int[] testCase : testCases) {
                System.out.println("Original array: ");
                System.out.println(java.util.Arrays.toString(testCase));
                solution.nextPermutation(testCase);
                System.out.println("Next permutation: ");
                System.out.println(java.util.Arrays.toString(testCase));
                System.out.println();
            }
        }
    }
}