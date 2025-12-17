import java.util.Arrays;
/**
 * This class provides a solution to the problem of getting the concatenation of an array with itself.
 * 
 * @author [Your Name]
 * @version 1.0
 */
/**
 * Approach: This solution uses a simple iterative approach to create a new array that is the concatenation of the input array with itself.
 * Time Complexity: O(n), where n is the length of the input array, because we are iterating over the array once to fill the new array.
 * Space Complexity: O(n), because we are creating a new array that is twice the size of the input array.
 */
public class GetConcatenation {
    class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] arr=new int[2*nums.length];
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
             arr[i]=nums[i];
             arr[i+n]=nums[i];
        }
    return arr;
    }
}
}

/**
 * Driver class to test the GetConcatenation class.
 */
public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {1, 2, 1};
        int[] result1 = solution.getConcatenation(test1);
        System.out.println("Test Case 1: " + Arrays.toString(result1));
        
        int[] test2 = {1, 3, 2, 1};
        int[] result2 = solution.getConcatenation(test2);
        System.out.println("Test Case 2: " + Arrays.toString(result2));
        
        int[] test3 = {1, 2};
        int[] result3 = solution.getConcatenation(test3);
        System.out.println("Test Case 3: " + Arrays.toString(result3));
    }
}