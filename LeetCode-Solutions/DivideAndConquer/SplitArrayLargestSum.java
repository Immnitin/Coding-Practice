import java.util.Arrays;

/**
 * Approach: Uses a Binary Search approach to find the largest sum of subarrays that can be achieved by splitting the given array into k subarrays.
 * The binary search is performed over the range of possible sums, from the maximum element in the array to the sum of all elements in the array.
 * For each mid value, the array is split into subarrays and the sum is checked. If the sum is achievable, the search space is reduced to the lower half; otherwise, it is reduced to the upper half.
 *
 * Time Complexity: O(n log m), where n is the number of elements in the array and m is the sum of all elements in the array.
 * Space Complexity: O(1), excluding the space required for the input array.
 */
public class SplitArrayLargestSum {
    class Solution {
    int sum=-1;
    public int splitArray(int[] nums, int k) {

        int st=0;
        int ed=0;

        for(int x :nums){
            ed+=x;
            st=Math.max(st,x);
        }

        bs(nums ,k ,st ,ed);
        return sum;

    }

    public void bs(int[] nums, int k, int st, int ed){
        if(st>ed){
            return ;
        }
        int mid=(st+ed)/2;
        boolean check=split(nums,k,mid);

        if(check==false){
            bs(nums,k,mid+1,ed);
        }
        else{
            sum=mid;
            bs(nums,k,st,mid-1);
        }
    }

    public boolean split(int[] nums, int reqsum, int mid){
        int i=0;
        int asum=0;
        int k=reqsum-1;
        while(i<nums.length){
            if(asum+nums[i]<=mid){
                asum+=nums[i];
            }
            else{
                k--;
                if(k<0){
                    return false;
                }
                asum=nums[i];
            }
            i++;
        }
        return true;
    }

}
}

class Driver {
    public static void main(String[] args) {
        SplitArrayLargestSum solution = new SplitArrayLargestSum();
        int[] nums1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        System.out.println("Test Case 1: " + solution.splitArray(nums1, k1));
        
        int[] nums2 = {1, 4, 4};
        int k2 = 3;
        System.out.println("Test Case 2: " + solution.splitArray(nums2, k2));
        
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k3 = 3;
        System.out.println("Test Case 3: " + solution.splitArray(nums3, k3));
    }
}