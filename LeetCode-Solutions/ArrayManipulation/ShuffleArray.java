import java.util.Arrays;
/**
 * This class provides a solution to shuffle an array of 2n elements into [a1, b1, a2, b2, ..., an, bn] format.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class Solution {
    /**
     * Shuffles an array of 2n elements into [a1, b1, a2, b2, ..., an, bn] format.
     * 
     * Approach: Uses two pointers, one starting from the beginning and one from the middle of the array, to interleave the elements.
     * Time Complexity: O(n), where n is the number of elements in the first half of the array.
     * Space Complexity: O(n), where n is the total number of elements in the array.
     * 
     * @param nums The input array to be shuffled.
     * @param n The number of elements in the first half of the array.
     * @return The shuffled array.
     */
    class Solution {
    public int[] shuffle(int[] nums, int n) {
       int[] arr=new int[2*n];
       int i=0;
       int j=n;
       int k=0;
       int l=1;
       while(k<nums.length || l<nums.length){
        arr[k]=nums[i];
        arr[k+1]=nums[j];
        i++;
        j++;
        k+=2;
        l+=2;
       }
       return arr;
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