import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Combination Sum III
 * Category: Backtracking / Combinatorics
 *
 * This implementation finds all unique combinations of k numbers that sum up to n,
 * where only numbers from 1 to 9 are used exactly once. The user's solution uses
 * a standard recursive backtracking approach (choose/skip).
 *
 * Time Complexity Analysis:
 * The problem operates on a fixed input set size N=9. The algorithm explores the combination space.
 * T(N, k) is bounded by O(C(N, k) * k), where C(N, k) is the number of combinations of choosing k elements from N.
 * Since N=9 is constant, the complexity is practically constant time relative to general input scaling.
 * T = O(2^N * N) (where N=9) for exploring the subset space and copying lists.
 *
 * Space Complexity Analysis:
 * Space complexity is dominated by the storage of the results and the recursion depth.
 * 1. Recursion Depth: The depth is at most N=9, contributing O(N) auxiliary space.
 * 2. Output Storage: The number of results is bounded by C(9, k), and each list is of size k.
 * S = O(C(N, k) * k).
 */
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        List<List<Integer>> res = new ArrayList<>();
        combination(nums, n, k, 0, n, new ArrayList<>(), res);
        return res;
    }

    public void combination(int[] nums, int target, int capacity, int idx, int sum, List<Integer> res1,
            List<List<Integer>> res) {
        if (idx >= nums.length || capacity == 0) {
            if (capacity == 0) {
                if (sum == 0) {
                    res.add(new ArrayList<>(res1));
                }
                return;
            } else {
                return;
            }
        }
        if (capacity < 0) {
            return;
        }
        if (sum < 0) {
            return;
        }
        //choose choice
        res1.add(nums[idx]);
        sum -= nums[idx];
        capacity--;
        combination(nums, target, capacity, idx + 1, sum, res1, res);
        sum += nums[idx];
        res1.remove(res1.size() - 1);
        capacity++;

        //skip choice
        combination(nums, target, capacity, idx + 1, sum, res1, res);
    }
}
class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("--- Combination Sum III Tests ---");

        // Test Case 1: k=3, n=7
        int k1 = 3;
        int n1 = 7;
        List<List<Integer>> result1 = solution.combinationSum3(k1, n1);
        // Expected: [[1, 2, 4]]
        System.out.println("k=" + k1 + ", n=" + n1 + " -> Result: " + result1);

        // Test Case 2: k=3, n=9
        int k2 = 3;
        int n2 = 9;
        List<List<Integer>> result2 = solution.combinationSum3(k2, n2);
        // Expected: [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
        System.out.println("k=" + k2 + ", n=" + n2 + " -> Result: " + result2);

        // Test Case 3: k=4, n=1 (Impossible sum, minimum k=4 sum is 10)
        int k3 = 4;
        int n3 = 1;
        List<List<Integer>> result3 = solution.combinationSum3(k3, n3);
        // Expected: []
        System.out.println("k=" + k3 + ", n=" + n3 + " -> Result: " + result3);

        // Test Case 4: k=9, n=45 (All numbers 1..9)
        int k4 = 9;
        int n4 = 45;
        List<List<Integer>> result4 = solution.combinationSum3(k4, n4);
        // Expected: [[1, 2, 3, 4, 5, 6, 7, 8, 9]]
        System.out.println("k=" + k4 + ", n=" + n4 + " -> Result: " + result4);
    }
}