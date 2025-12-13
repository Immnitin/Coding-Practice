import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Time Complexity: O(N * N!)
 * The algorithm generates N! distinct permutations. Since constructing and storing each permutation takes O(N) time (or O(1) amortized work per state transition in the recursion tree, summing up to O(N*N!)), the overall time complexity is O(N * N!).
 * 
 * Space Complexity: O(N * N!)
 * This complexity is dominated by the space required to store the output (N! lists, each of size N). The auxiliary space used for the recursion stack (depth N) and the temporary list/map is O(N).
 * 
 * Category: Backtracking / Recursion
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
     boolean[] map=new boolean[nums.length];
     Arrays.fill(map,false);
     List<Integer> res1=new ArrayList<>();
     List<List<Integer>> res=new ArrayList<>();
     permutations(nums,map,0,res1,res);
     return res;
    }
    public void permutations(int[] nums,boolean[] map,int idx,List<Integer> res1,List<List<Integer>> res){
        if(res1.size()==nums.length){
            res.add(new ArrayList<>(res1));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!map[i]){
                map[i]=true;
                res1.add(nums[i]);
                permutations(nums,map,i,res1,res);
                res1.remove(res1.size()-1);
                map[i]=false;
            }
        }
    }
}

class Driver {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Standard three elements
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result1 = sol.permute(nums1);
        System.out.println("--- Test Case 1 ---");
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output (Permutations): " + result1.size() + " lists");
        printResults(result1);

        // Test Case 2: Two elements
        int[] nums2 = {0, 1};
        List<List<Integer>> result2 = sol.permute(nums2);
        System.out.println("\n--- Test Case 2 ---");
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output (Permutations): " + result2.size() + " lists");
        printResults(result2);

        // Test Case 3: Single element
        int[] nums3 = {5};
        List<List<Integer>> result3 = sol.permute(nums3);
        System.out.println("\n--- Test Case 3 ---");
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output (Permutations): " + result3.size() + " lists");
        printResults(result3);
    }

    private static void printResults(List<List<Integer>> results) {
        if (results == null || results.isEmpty()) {
            System.out.println("[]");
            return;
        }
        for (List<Integer> list : results) {
            System.out.println(list);
        }
    }
}