import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * This class provides a solution to find missing elements in an array.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class Solution {
    /**
     * Finds missing elements in the given array.
     * 
     * Approach: This solution uses a HashSet to store the elements of the array and then iterates over the range of the minimum and maximum values in the array to find the missing elements.
     * 
     * Time Complexity: O(n) where n is the number of elements in the array, because we are doing a constant amount of work for each element in the array.
     * 
     * Space Complexity: O(n) where n is the number of elements in the array, because in the worst case, we might need to store all elements in the HashSet.
     * 
     * @param nums the input array
     * @return a list of missing elements
     */
    class Solution {
    public List<Integer> findMissingElements(int[] nums) {
     int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = min + 1; i < max; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 4, 6};
        int[] nums2 = {1, 2, 3, 5};
        int[] nums3 = {10, 12, 15};
        System.out.println(solution.findMissingElements(nums1));
        System.out.println(solution.findMissingElements(nums2));
        System.out.println(solution.findMissingElements(nums3));
    }
}