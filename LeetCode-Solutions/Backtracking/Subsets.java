import java.util.*;

/**
 * Problem: Subsets
 * Category: Backtracking / Recursion / Combinatorics
 *
 * This implementation uses a standard recursive backtracking approach to generate all possible subsets 
 * of a given set of integers (nums). At each index, the algorithm makes two fundamental decisions:
 * 1. Exclude the current element (recursion call without adding nums[idx]).
 * 2. Include the current element (add nums[idx], then recursion call, followed by backtracking removal).
 *
 * Time Complexity: O(N * 2^N)
 * The algorithm generates 2^N subsets. For each subset generated, we spend O(N) time copying the current 
 * subset (res1) into the result list (res.add(new ArrayList<>(res1))). The total number of operations
 * is dominated by the generation and copying of results.
 *
 * Space Complexity: O(N * 2^N)
 * This includes the space required to store the 2^N subsets in the result list (List<List<Integer>> res).
 * The auxiliary space (recursion stack depth and temporary list management) is O(N).
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        generate(nums,0,nums.length,res,new ArrayList<>());
        return res;
    }
    public void generate(int[] nums, int idx,int n, List<List<Integer>> res,List<Integer> res1){
        if(idx>=n){
          res.add(new ArrayList<Integer>(res1));
          return; 
        }
        generate(nums,idx+1,n,res,res1); 
        res1.add(nums[idx]);
        generate(nums,idx+1,n,res,res1);
        res1.remove(res1.size()-1);
    }
}

class Driver {
    private static void test(int[] nums) {
        Solution sol = new Solution();
        System.out.println("Input: " + Arrays.toString(nums));
        List<List<Integer>> result = sol.subsets(nums);
        
        // Sort internal lists for consistent display
        for (List<Integer> subset : result) {
            Collections.sort(subset);
        }
        
        // Sort the list of lists based on size and content for predictable printout
        result.sort((a, b) -> {
            if (a.size() != b.size()) {
                return a.size() - b.size();
            }
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) != b.get(i)) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });

        System.out.println("Subsets found (" + result.size() + "): " + result);
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("--- Testing Subsets Generation ---");
        
        // Test Case 1: Standard input
        int[] nums1 = {1, 2, 3};
        test(nums1);

        // Test Case 2: Single element
        int[] nums2 = {0};
        test(nums2);

        // Test Case 3: Empty input
        int[] nums3 = {};
        test(nums3);
    }
}