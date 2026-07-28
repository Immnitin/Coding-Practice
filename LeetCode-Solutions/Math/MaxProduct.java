import java.util.Arrays;

/**
 * This class provides a solution to the problem of finding the maximum product of two numbers in an array.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class MaxProduct {
    /**
     * This method calculates the maximum product of two numbers in the given array.
     * 
     * <p>Approach: The solution uses a simple sorting approach to find the maximum product of two numbers in the array.
     * If the array has two or fewer elements, it directly calculates the product. Otherwise, it sorts the array and returns the product of the last two elements minus one.
     * 
     * <p>Time Complexity: O(n log n) due to the sorting operation, where n is the number of elements in the array.
     * <p>Space Complexity: O(1) if the sorting is done in-place, or O(n) if a new array is created for sorting.
     * 
     * @param nums the input array of integers
     * @return the maximum product of two numbers in the array
     */
    class Solution {
    public int maxProduct(int[] nums) {
        
        if(nums.length<=2){
            return (nums[nums.length-2]-1)*(nums[nums.length-1]-1);
        }
        Arrays.sort(nums);

        return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
    }
}
}

/**
 * This class provides a driver to test the MaxProduct class.
 */
public class Driver {
    public static void main(String[] args) {
        MaxProduct solution = new MaxProduct();
        int[] testCases = {
            {1, 2, 3, 4, 5},
            {10, 20, 30},
            {5, 5}
        };
        for (int[] testCase : testCases) {
            System.out.println("Maximum product for array ");
            System.out.println(java.util.Arrays.toString(testCase));
            System.out.println("is: " + solution.maxProduct(testCase));
        }
    }
}