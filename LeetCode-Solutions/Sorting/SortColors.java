import java.util.Arrays;
/**
 * Approach: Uses a modified Merge Sort algorithm to sort the array in-place.
 * The algorithm recursively divides the array into two halves until each sub-array contains only one element, and then merges the sub-arrays back together in sorted order.
 * Time Complexity: O(n log n), where n is the number of elements in the array.
 * Space Complexity: O(n), where n is the number of elements in the array.
 */
class Solution {
    public void sortColors(int[] nums) {
        partition(nums, 0, nums.length - 1);
    }

    public static void partition(int[] nums, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        partition(nums, si, mid);
        partition(nums, mid + 1, ei);
        merge(nums, mid, si, ei);
    }

    public static void merge(int[] arr, int mi, int si, int ei) {
        int[] t = new int[ei-si+1];
        int i = si;
        int k = 0;
        int j = mi + 1;
        while (i <= mi && j <= ei) {
            if (arr[i] <= arr[j]) {
                t[k++] = arr[i++];
            } else  {
                t[k++] = arr[j++];
            }
        }
        while (i <= mi) {
            t[k++] = arr[i++];
        }
        while (j <=ei) {
            t[k++] = arr[j++];
        }
        for (int p =si; p <=ei ; p++) {
            arr[p] = t[p-si];
        }
    }
}


public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {2, 0, 2, 1, 1, 0};
        solution.sortColors(test1);
        System.out.println(Arrays.toString(test1));
        int[] test2 = {2, 0, 1};
        solution.sortColors(test2);
        System.out.println(Arrays.toString(test2));
        int[] test3 = {0, 1, 2, 0, 1, 2};
        solution.sortColors(test3);
        System.out.println(Arrays.toString(test3));
    }
}