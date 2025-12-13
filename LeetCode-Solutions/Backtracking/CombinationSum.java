import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Solution for the Combination Sum problem.
 * This class finds all unique combinations of candidates where the candidate numbers sum up to a target.
 * Candidates can be reused unlimited times.
 *
 * <p><h3>Complexity Analysis:</h3>
 * The problem is solved using Depth First Search (DFS) / Backtracking.
 * <ul>
 * <li><b>Time Complexity:</b> O(N * 2^T).
 *     Let N be the number of candidates and T be the target value. The exact time complexity for Combination Sum is difficult to precisely calculate due to varying candidate values, but it is exponential. If C_min is the smallest candidate, the maximum recursion depth is T/C_min. The time complexity is generally bounded by the total number of combinations multiplied by the time taken to copy each combination (which is proportional to its length, T/C_min).
 * </li>
 * <li><b>Space Complexity:</b> O(D + O), where D is the maximum depth of the recursion stack (D ≈ T / min(candidates)) and O is the space required to store the output list of combinations. The space is dominated by the potentially exponential size of the output list.
 * </li>
 * </ul>
 */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {   List<List<Integer>> res=new ArrayList<>();
    List<Integer> res1=new ArrayList<>();
    int sum=target;
    combination(candidates,target,0,sum,res,res1);
    return res;

    }
    public void combination(int[] candidates,int target,int idx,int sum,List<List<Integer>> res,List<Integer> res1){
        if(sum==0){
             res.add(new ArrayList<>(res1));
                return;
        }
        if(idx>=candidates.length){
            if(sum==0){
                res.add(new ArrayList<>(res1));
                return;
            }
            else return;
        }
        
        if(candidates[idx]<=sum){
            res1.add(candidates[idx]);
            sum-=candidates[idx];
            combination(candidates,target,idx,sum,res,res1);
            sum+=candidates[idx];
            res1.remove(res1.size()-1);
        }
            combination(candidates,target,idx+1,sum,res,res1);
    }
}

public class CombinationSum {

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Standard case
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        List<List<Integer>> result1 = sol.combinationSum(candidates1, target1);
        System.out.println("Test Case 1:");
        System.out.println("Candidates: " + Arrays.toString(candidates1) + ", Target: " + target1);
        System.out.println("Result: " + result1);
        // Expected: [[2, 2, 3], [7]] (Order of inner lists might vary)

        System.out.println("-------------------------");

        // Test Case 2: Many re-uses
        int[] candidates2 = {2, 4, 8};
        int target2 = 8;
        List<List<Integer>> result2 = sol.combinationSum(candidates2, target2);
        System.out.println("Test Case 2:");
        System.out.println("Candidates: " + Arrays.toString(candidates2) + ", Target: " + target2);
        System.out.println("Result: " + result2);
        // Expected: [[2, 2, 2, 2], [2, 2, 4], [4, 4], [8]]

        System.out.println("-------------------------");

        // Test Case 3: No solution possible
        int[] candidates3 = {3, 5};
        int target3 = 2;
        List<List<Integer>> result3 = sol.combinationSum(candidates3, target3);
        System.out.println("Test Case 3:");
        System.out.println("Candidates: " + Arrays.toString(candidates3) + ", Target: " + target3);
        System.out.println("Result: " + result3);
        // Expected: []
    }
}