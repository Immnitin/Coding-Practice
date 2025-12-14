import java.util.Arrays;

/**
 * This class provides a solution to find the missing multiple in a sorted array.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class MissingMultiple {
    /**
     * Finds the missing multiple in a sorted array.
     * 
     * Approach: Uses a modified binary search algorithm to find the missing multiple.
     * The algorithm sorts the array and then uses a binary search to find the first occurrence of the target value.
     * If the target value is found, it increments the target value and repeats the search until the target value is not found.
     * 
     * Time Complexity: O(n log n) due to the sorting operation, where n is the number of elements in the array.
     * Space Complexity: O(1) as no additional space is used that scales with input size.
     * 
     * @param arr the input array
     * @param k the multiple to find
     * @return the missing multiple
     */
    class Solution {
    public int missingMultiple(int[] arr, int k) {
        Arrays.sort(arr);
        int max=0;
        int st=0;
        int ed=arr.length-1;
        int mid=0;
        int target=k;
        while(st<=ed){
            mid=(st+ed)/2;
            if(arr[mid]>=target){
                ed=mid-1;
            }
            else if(arr[mid]<=target){
                st=mid+1;
            }
            if(arr[mid]==target){
                target+=k;
                st=0;
                ed=arr.length-1;
                max=Math.max(target,max);
            }
        }
        if(st>=ed){
            return target;
        }
        else return max;
    }
}
}

/**
 * Driver class to test the MissingMultiple class.
 */
public class Driver {
    public static void main(String[] args) {
        MissingMultiple solution = new MissingMultiple();
        int[] arr1 = {1, 2, 3, 4, 6, 7, 8, 9};
        int k1 = 2;
        System.out.println("Missing multiple: " + solution.missingMultiple(arr1, k1));
        
        int[] arr2 = {1, 3, 5, 7, 9};
        int k2 = 2;
        System.out.println("Missing multiple: " + solution.missingMultiple(arr2, k2));
        
        int[] arr3 = {2, 4, 6, 8, 10};
        int k3 = 2;
        System.out.println("Missing multiple: " + solution.missingMultiple(arr3, k3));
    }
}