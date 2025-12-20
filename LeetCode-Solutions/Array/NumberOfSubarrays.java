import java.util.Arrays;
/**
 * Approach: Uses a sliding window technique to track the number of subarrays with at most k odd numbers.
 * Time Complexity: O(n), where n is the length of the input array.
 * Space Complexity: O(1), as only a constant amount of space is used.
 */
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return  cntsub(nums,k)-cntsub(nums,k-1);
    }
    public int cntsub(int[] nums, int k){
         int lt=0;
        int rt=0;
        int cnt=0;
        int cntodd=0;
        while(rt<nums.length){
            int num=nums[rt];
            if(num%2!=0){
                cntodd++;
            }
            while(cntodd>k){
                if(lt<nums.length && nums[lt]%2!=0){
                    cntodd--;
                }
                lt++;
            }
            if(cntodd<=k){
                cnt+=rt-lt+1;
            }
            rt++;
        }
        return cnt;
    }
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {1, 1, 2, 1, 1},
            {2, 4, 6},
            {1, 3, 5}
        };
        int[] ks = {3, 1, 2};
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Input: nums = " + Arrays.toString(testCases[i]) + ", k = " + ks[i]);
            System.out.println("Output: " + solution.numberOfSubarrays(testCases[i], ks[i]) + " subarrays");
            System.out.println();
        }
    }
}