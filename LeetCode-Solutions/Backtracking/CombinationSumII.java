
import java.util.*;

/**
 * This class provides a solution to the Combination Sum II problem.
 * 
 * Approach: 
 * Uses a backtracking approach to find all unique combinations in the given array that sum up to the target.
 * The array is first sorted, and then a recursive function is used to explore all possible combinations.
 * 
 * Time Complexity: 
 * O(2^n) in the worst case, where n is the number of elements in the array.
 * However, the actual time complexity is less due to the pruning of branches where the current sum exceeds the target.
 * 
 * Space Complexity: 
 * O(n) for the recursive call stack.
 * 
 * @author [Your Name]
 */
public class CombinationSumII {
    class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();
        int sum = target;
        combination(candidates, target, 0, sum, res, res1);
        return res;
    }

    public void combination(int[] candidates, int target, int idx, int sum, List<List<Integer>> res,
            List<Integer> res1) {
        if (sum == 0) {
            res.add(new ArrayList<>(res1));
            return;
        }
        if (idx >= candidates.length) {
            if (sum == 0) {
                res.add(new ArrayList<>(res1));
                return;
            } else
                return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > sum) {
                break;
            }
            res1.add(candidates[i]);
            sum -= candidates[i];
            combination(candidates, target, i + 1, sum, res, res1);
            sum += candidates[i];
            res1.remove(res1.size() - 1);
        }

    }
}

    public static class Driver {
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[][] testCases = {
                {10,1,2,7,6,1,5},
                {2,5,2,1,2},
                {1,1,1}
            };
            int[] targets = {8, 5, 3};
            for (int i = 0; i < testCases.length; i++) {
                System.out.println("Test Case " + (i + 1) + ":");
                System.out.println("Input: candidates = [" + Arrays.toString(testCases[i]) + "], target = " + targets[i]);
                System.out.println("Output: " + solution.combinationSum2(testCases[i], targets[i]));
                System.out.println();
            }
        }
    }
}