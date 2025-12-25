import java.util.Arrays;
/**
 * This class provides a solution to the problem of finding the number of smaller elements than the current element in an array.
 * 
 * @author [Your Name]
 */
/**
 * Approach: This solution uses a nested loop approach to compare each element with every other element in the array.
 * For each element, it increments a counter whenever it finds a smaller element. The result is an array where each element represents the number of smaller elements than the corresponding element in the input array.
 * 
 * Time Complexity: O(n^2) where n is the length of the input array, because for each element, we are potentially comparing it with every other element.
 * 
 * Space Complexity: O(n) where n is the length of the input array, because we need to store the result in an array of the same length.
 */
public class Solution {
    class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j && nums[j]<nums[i]){
                    res[i]++;
                }
            }
        }
        return res;
    }
}
}

/**
 * Driver class to test the solution.
 */
public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {8,1,2,2,3},
            {6,5,4,8},
            {7,7,7,7}
        };
        for (int[] testCase : testCases) {
            int[] result = solution.smallerNumbersThanCurrent(testCase);
            System.out.println("Input: " + Arrays.toString(testCase));
            System.out.println("Result: " + Arrays.toString(result));
        }
    }
}