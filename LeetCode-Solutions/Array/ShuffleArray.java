import java.util.Arrays;
/**
 * This class provides a solution to shuffle an array of 2n elements into [x1, x2, ..., xn, y1, y2, ..., yn] format.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class Solution {
    /**
     * Shuffles the input array into the required format.
     * 
     * @param nums The input array of 2n elements.
     * @param n The number of elements in the first half of the array.
     * @return The shuffled array.
     * 
     * Approach: Uses two separate arrays to store the first and second halves of the input array, then merges them in an alternating manner.
     * Time Complexity: O(n), where n is the number of elements in the first half of the array.
     * Space Complexity: O(n), where n is the number of elements in the first half of the array.
     */
    class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] first=new int[n];
        int[] second =new int[n];
        int i=0;
        while(i<n){
            first[i]=nums[i];
            i++;
        }
        int j=0;
        while(j<n){
            second[j]=nums[i];
            j++;
            i++;
        }
        int w=0;
        int b=0;
        int p=0;
        while(p<nums.length){
            if(p%2==0){
            nums[p]=first[b];
            b++;}
            else
            {nums[p]=second[w];
            w++;}
            p++;
        }
        return nums;
    }
}
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int n1 = 3;
        System.out.println(Arrays.toString(solution.shuffle(nums1, n1)));
        
        int[] nums2 = {7, 8, 9, 10, 11, 12};
        int n2 = 3;
        System.out.println(Arrays.toString(solution.shuffle(nums2, n2)));
        
        int[] nums3 = {1, 3, 5, 2, 4, 6};
        int n3 = 3;
        System.out.println(Arrays.toString(solution.shuffle(nums3, n3)));
    }
}