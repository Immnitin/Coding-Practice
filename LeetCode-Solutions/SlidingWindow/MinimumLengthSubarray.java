
import java.util.HashMap;

/**
 * This class provides a solution to find the minimum length of a subarray 
 * that has a sum greater than or equal to a given target value.
 * 
 * Approach: Uses a Sliding Window technique to track the minimum length 
 * of the subarray. It maintains a HashMap to store the frequency of each 
 * element in the current window and updates the minimum length whenever 
 * the sum of the elements in the window is greater than or equal to the target.
 * 
 * Time Complexity: O(n), where n is the length of the input array.
 * 
 * Space Complexity: O(n), where n is the length of the input array.
 */
public class MinimumLengthSubarray {
    class Solution {
    public int minLength(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int lt=0;
        int rt;
        int sum=0;
        int minl=Integer.MAX_VALUE;
        for(rt=0;rt<nums.length;rt++){ 
map.put(nums[rt],map.getOrDefault(nums[rt],0)+1);
            if(map.get(nums[rt])==1){
                sum+=nums[rt];
            }
        while(sum>=k){
            minl=Math.min(minl,rt-lt+1);
            map.put(nums[lt],map.getOrDefault(nums[lt],0)-1);
            if(map.get(nums[lt])==0){
                sum-=nums[lt];
            }
            lt++;
        }
        }
        if(minl==Integer.MAX_VALUE){
            return -1;
        }
        return minl;
    }
}

    public static class Driver {
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] nums1 = {1, 2, 3, 4, 5};
            int k1 = 7;
            System.out.println("Minimum length subarray with sum >= " + k1 + ": " + solution.minLength(nums1, k1));

            int[] nums2 = {2, 3, 1, 2, 4, 3};
            int k2 = 7;
            System.out.println("Minimum length subarray with sum >= " + k2 + ": " + solution.minLength(nums2, k2));

            int[] nums3 = {1, 1, 1, 1, 1};
            int k3 = 11;
            System.out.println("Minimum length subarray with sum >= " + k3 + ": " + solution.minLength(nums3, k3));
        }
    }
}