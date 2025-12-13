import java.util.*;

/**
 * Subsets II (Subsets with Duplicates)
 * 
 * Given an integer array nums that may contain duplicates, the goal is to return all possible 
 * unique subsets (the power set). The user's solution utilizes the standard recursive 
 * backtracking approach. Crucially, it sorts the input array first and then implements a 
 * skip condition (if(i!=idx && nums[i]==nums[i-1])continue;) within the backtracking loop 
 * to ensure duplicate subsets are not generated.
 * 
 * Time Complexity Analysis:
 * The overall complexity is O(N * 2^N).
 * 1. Sorting the input takes O(N log N).
 * 2. The generation process explores the search space, pruning branches where duplicates occur. 
 *    However, in the worst-case scenario (where all elements are unique), there are 2^N subsets.
 *    Since copying the list of size up to N happens for every valid subset found, the generation 
 *    and storage dominate, resulting in O(N * 2^N).
 * 
 * Space Complexity Analysis:
 * The space complexity is O(N * 2^N).
 * 1. This space is required to store the final list of subsets (the result structure).
 * 2. The recursion depth is O(N).
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        subset(nums,0,new ArrayList<>(),res);
        return res;
    }
    public void subset(int[] nums, int idx, List<Integer> res1, List<List<Integer>> res){
        res.add(new ArrayList<>(res1));
        for(int i=idx;i<nums.length;i++){
            if(i!=idx && nums[i]==nums[i-1])continue;
            res1.add(nums[i]);
            subset(nums,i+1,res1,res);
            res1.remove(res1.size()-1);
        }
    }
}

class Driver {
    
    // Helper method to print the result list in a consistent, sorted order for verification
    public static void printResult(List<List<Integer>> result) {
        
        // 1. Sort the inner lists (subsets) for consistent internal representation
        for (List<Integer> subset : result) {
            Collections.sort(subset);
        }
        
        // 2. Sort the outer list based on lexicographical order of subsets
        Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                int i = 0;
                while (i < a.size() && i < b.size()) {
                    int comparison = a.get(i).compareTo(b.get(i));
                    if (comparison != 0) return comparison;
                    i++;
                }
                return Integer.compare(a.size(), b.size());
            }
        });

        System.out.println(result);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test Case 1: Standard duplicates
        int[] nums1 = {1, 2, 2};
        System.out.println("--- Test Case 1 ---");
        System.out.println("Input: " + Arrays.toString(nums1));
        List<List<Integer>> res1 = sol.subsetsWithDup(nums1);
        System.out.print("Output: ");
        printResult(res1);
        // Expected unique subsets: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]

        // Test Case 2: Array with unique elements (to verify base functionality)
        int[] nums2 = {4, 1, 0};
        System.out.println("\n--- Test Case 2 ---");
        System.out.println("Input: " + Arrays.toString(nums2));
        List<List<Integer>> res2 = sol.subsetsWithDup(nums2);
        System.out.print("Output: ");
        printResult(res2);
        // Expected 8 unique subsets

        // Test Case 3: Many duplicates
        int[] nums3 = {4, 4, 4, 1, 4};
        System.out.println("\n--- Test Case 3 ---"); 
        System.out.println("Input: " + Arrays.toString(nums3) + " (Sorted internally: [1, 4, 4, 4, 4])");
        List<List<Integer>> res3 = sol.subsetsWithDup(nums3);
        System.out.print("Output: ");
        printResult(res3);
        // Expected: 10 unique subsets
    }
}