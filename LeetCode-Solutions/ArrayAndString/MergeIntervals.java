
import java.util.*;

/**
 * This class provides a solution to the Merge Intervals problem.
 * 
 * Approach: 
 * The algorithm uses a sorting-based approach to merge overlapping intervals. 
 * It first sorts the intervals based on their start values. Then, it iterates over the sorted intervals, 
 * merging any overlapping intervals it finds. If an interval does not overlap with the previous one, 
 * it is added to the result list.
 * 
 * Time Complexity: 
 * The time complexity of this solution is O(n log n) due to the sorting operation, 
 * where n is the number of intervals. The subsequent for loop has a time complexity of O(n), 
 * but it does not dominate the overall time complexity.
 * 
 * Space Complexity: 
 * The space complexity of this solution is O(n), where n is the number of intervals. 
 * This is because in the worst-case scenario, we might need to store all intervals in the result list.
 */
public class MergeIntervals {
    class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int st1 = arr[0][0];
        int end1 = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            int st2 = arr[i][0];
            int end2 = arr[i][1];
            if (end1 >= st2) {
                end1 = Math.max(end1, end2);
            } else {
                res.add(new ArrayList<>(List.of(st1, end1)));
                st1 = st2;
                end1 = end2;
            }
        }
        res.add(new ArrayList<>(List.of(st1, end1)));
        int[][] a = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            a[i][0] = res.get(i).get(0);
            a[i][1] = res.get(i).get(1);
        }
        return a;
    }
}

    public static class Driver {
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[][][] testCases = {
                {{1, 3}, {2, 6}, {8, 10}, {15, 18}},
                {{1, 4}, {4, 5}},
                {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}
            };

            for (int[][] testCase : testCases) {
                int[][] result = solution.merge(testCase);
                System.out.println("Merged Intervals: ");
                for (int[] interval : result) {
                    System.out.println("[" + interval[0] + ", " + interval[1] + "]");
                }
            }
        }
    }
}
