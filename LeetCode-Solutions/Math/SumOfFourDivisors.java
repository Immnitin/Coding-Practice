import java.util.Arrays;
/**
 * This class provides a solution to the problem of finding the sum of four divisors.
 * 
 * @author [Your Name]
 * @version 1.0
 */
/**
 * Approach: This solution uses a helper function to calculate the sum of divisors for each number in the input array.
 * It sorts the input array and then iterates over it, using the helper function to calculate the sum of divisors for each number.
 * If a number has exactly four divisors, its sum is added to the total sum.
 * 
 * Time Complexity: O(n log n) due to the sorting, where n is the length of the input array.
 * The helper function has a time complexity of O(sqrt(m)), where m is the maximum number in the input array.
 * 
 * Space Complexity: O(1) for the helper function, and O(n) for the sorting.
 */
class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum=0;
        int i=0;
        Arrays.sort(nums);
        int[] ans=new int[2];
        ans=helper(nums,i);
        sum+=ans[1];
        for(i=1;i<nums.length;i++){
            if(nums[i-1]!=nums[i])
                {ans=helper(nums,i);
                // System.out.println(Arrays.toString(ans));
            sum+=ans[1];}
            else {
            if(ans[0]==1){
                sum+=ans[1];
            }
        }
        }
        return sum;
    }
    public int[] helper(int[] nums, int j){
        int[] ans;
        int cnt=0;
        int sum=0;
        for(int i=1;i<=nums[j]/2;i++){
            if(nums[j]%i==0){
                cnt++;
                sum+=i;
                if(cnt>4){
                    break;
                }
            }
        }
        cnt++;
        if(cnt>4 || cnt<4){
            return new int[]{0,0};
        }
        return new int[]{1,sum+nums[j]};
    }
}

/**
 * Driver class to test the solution.
 */
public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {21, 4, 7};
        int[] nums2 = {9, 7, 4, 2, 10};
        int[] nums3 = {21, 21, 21};
        System.out.println("Test Case 1: " + solution.sumFourDivisors(nums1));
        System.out.println("Test Case 2: " + solution.sumFourDivisors(nums2));
        System.out.println("Test Case 3: " + solution.sumFourDivisors(nums3));
    }
}