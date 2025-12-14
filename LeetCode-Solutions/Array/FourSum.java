
import java.util.*;

/**
 * This class provides a solution to the 4Sum problem.
 * 
 * Approach: 
 * The algorithm uses a two-pointer technique to find four numbers in the array that sum up to the target.
 * It first sorts the array and then uses two nested loops to fix the first two numbers.
 * The two-pointer technique is then used to find the remaining two numbers.
 * 
 * Time Complexity: 
 * The time complexity of this solution is O(n^3), where n is the number of elements in the array.
 * This is because there are three nested loops in the solution.
 * 
 * Space Complexity: 
 * The space complexity of this solution is O(n), where n is the number of elements in the array.
 * This is because in the worst case, the solution might store all the elements in the result list.
 */
public class Solution {
    class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> arr = new ArrayList<>();
        int cnt = 0;
        if (nums.length < 4) {
            return arr;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                cnt++;
            }
        }
        if (cnt == nums.length - 1) {
            if ((long) nums[0] + nums[1] + nums[2] + nums[3] == target) {
                List<Integer> res = new ArrayList<>(List.of(nums[0], nums[1], nums[2], nums[3]));
                arr.add(res);
                return arr;
            } else
                return arr;
        }
        for (int i = 0; i < nums.length-3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length-2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == (long) target) {
                        List<Integer> res = new ArrayList<>(List.of(nums[i], nums[j], nums[k], nums[l]));
                        arr.add(res);
                        while (k < l && nums[k] == nums[k + 1])
                            k++;
                        while (k < l && nums[l] == nums[l - 1])
                            l--;
                        k++;
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    }
                }
            }
        }
        return arr;
    }
}
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {1, 0, -1, 0, -2, 2},
            {2, 2, 2, 2, 2},
            {-2, -1, -1, 1, 1, 2, 2}
        };
        int[] targets = {0, 8, 0};
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Input: " + Arrays.toString(testCases[i]));
            System.out.println("Target: " + targets[i]);
            System.out.println("Result: " + solution.fourSum(testCases[i], targets[i]));
            System.out.println();
        }
    }
}