import java.util.HashMap;
/**
 * This class provides a solution to the subarray sum problem.
 * 
 * @author [Your Name]
 * @version 1.0
 */
/**
 * Approach: Uses a prefix sum and hashmap approach to efficiently count the number of subarrays with a given sum.
 * Time Complexity: O(n), where n is the number of elements in the input array.
 * Space Complexity: O(n), where n is the number of elements in the input array.
 */
public class Solution {
    class Solution {
    public int subarraySum(int[] nums, int k) {
        // this approach only works for array with postive numbers
        // int i=0;
        // int j=0;
        // int sum=0;
        // int cnt=0;

        // while( j<nums.length && i<=j){
        //     sum+=nums[j];
        //     while (sum > k && i <= j) {
        //         sum -= nums[i];
        //         i++;
        //     }
        //     if(sum==k){
        //         cnt++;
        //     }
        //     j++;

        // }
        // return cnt;

        //using prefix sum and hashmap approach 
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0,cnt=0;
        for(int num:nums){
            sum+=num;
            // System.out.println(sum+" "+(sum-k));
            // System.out.println(map);
            if(map.containsKey(sum-k)){
                cnt+=map.get(sum-k);
            }

            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        // System.out.println(map);
        return cnt;
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Test Case 1: " + solution.subarraySum(nums1, k1));
        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("Test Case 2: " + solution.subarraySum(nums2, k2));
        int[] nums3 = {1, 2, 1, 2, 1};
        int k3 = 3;
        System.out.println("Test Case 3: " + solution.subarraySum(nums3, k3));
    }
}