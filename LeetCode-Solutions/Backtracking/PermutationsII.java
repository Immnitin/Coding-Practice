import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * PermutationsII
 *
 * This problem requires finding all unique permutations of an array that may contain duplicate elements.
 * The provided solution uses a backtracking approach combined with pruning logic to skip redundant
 * branches caused by duplicates.
 *
 * The core pruning step is implemented after sorting the array:
 * `if (i > 0 && nums[i] == nums[i - 1] && !map[i - 1]) continue;`
 * This check ensures that if we encounter a duplicate number (nums[i]), we only consider it if the
 * previous identical number (nums[i-1]) was already used in the current recursive path (i.e., map[i-1] is true).
 * If map[i-1] is false, it means we chose to skip nums[i-1] at this level, and thus must skip nums[i] as well to prevent
 * generating the same permutation structure multiple times.
 *
 * Time Complexity: O(N * P)
 * Where N is the number of elements, and P is the total number of unique permutations. P is bounded by N!. The factor N comes from copying the list result into the final collection.
 *
 * Space Complexity: O(N * P)
 * O(N) auxiliary space is used for the recursion stack depth (N levels) and the 'map' boolean array. O(N * P) space is required to store the resulting list of lists.
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
    boolean[] map=new boolean[nums.length];
     Arrays.fill(map,false);
     List<Integer> res1=new ArrayList<>();
     List<List<Integer>> res=new ArrayList<>();
     Arrays.sort(nums);
     permutations(nums,map,0,res1,res);
     return res;
    }
    public void permutations(int[] nums,boolean[] map,int idx,List<Integer> res1,List<List<Integer>> res){
        if(res1.size()==nums.length){
            res.add(new ArrayList<>(res1));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(map[i]){
                continue;
            }
            if(i>0 && nums[i]==nums[i-1] && !map[i-1]) continue;
                map[i]=true;
                res1.add(nums[i]);
                permutations(nums,map,i,res1,res);
                res1.remove(res1.size()-1);
                map[i]=false;
        }
    }
}

class Driver {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Standard duplicates
        int[] nums1 = {1, 1, 2};
        List<List<Integer>> result1 = sol.permuteUnique(nums1);
        System.out.println("Input: " + Arrays.toString(nums1));
        // Expected Output size: 3
        System.out.println("Output (1,1,2): " + result1);
        System.out.println("---");

        // Test Case 2: No duplicates (standard permutation)
        int[] nums2 = {1, 2, 3};
        List<List<Integer>> result2 = sol.permuteUnique(nums2);
        System.out.println("Input: " + Arrays.toString(nums2));
        // Expected Output size: 6
        System.out.println("Output (1,2,3): " + result2);
        System.out.println("---");

        // Test Case 3: More complex duplicates
        int[] nums3 = {2, 2, 1, 1};
        List<List<Integer>> result3 = sol.permuteUnique(nums3);
        System.out.println("Input: " + Arrays.toString(nums3));
        // Expected Output size: 6
        System.out.println("Output (2,2,1,1): " + result3);
        System.out.println("---");
    }
}