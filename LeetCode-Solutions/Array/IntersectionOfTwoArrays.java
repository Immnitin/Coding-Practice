import java.util.HashSet;
import java.util.stream.IntStream;
/**
 * This class provides a solution to find the intersection of two arrays.
 * 
 * @author [Your Name]
 * @version 1.0
 * @since [Date]
 *
 * <h2>Approach:</h2>
 * Uses two HashSets to store unique elements from both input arrays, then retains only the common elements in the first set.
 * 
 * <h2>Time Complexity:</h2>
 * O(n + m), where n and m are the lengths of the input arrays, because we perform a constant amount of work for each element in both arrays.
 * 
 * <h2>Space Complexity:</h2>
 * O(n + m), because in the worst case, all elements from both arrays are stored in the HashSets.
 */
public class Solution {
    class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> s1=new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            s1.add(nums1[i]);
        }
       HashSet<Integer> s2=new HashSet<>();
       for(int i=0;i<nums2.length;i++){
        s2.add(nums2[i]);
       }
       s1.retainAll(s2);
       return s1.stream().mapToInt(Integer::intValue).toArray();
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {1, 2, 2, 1},
            {2, 2},
            {4, 9, 5}
        };
        int[][] testCases2 = {
            {2, 2},
            {2},
            {9, 4, 9, 8, 4}
        };
        for (int i = 0; i < testCases.length; i++) {
            int[] result = solution.intersection(testCases[i], testCases2[i]);
            System.out.println("Test Case " + (i + 1) + ": " + java.util.Arrays.toString(result));
        }
    }
}