import java.util.*;\n\n/**\n * Solution for the Minimum Difference problem using a meet-in-the-middle approach.\n *\n * Approach:\n * The array is split into two halves. For each half we generate all possible subset sums\n * grouped by the number of elements chosen. For a total of n elements we need to pick n/2\n * elements. For each possible count k from the left half we look for (n/2 - k) elements from\n * the right half such that the combined sum is as close as possible to totalSum/2. The right\n * side lists are sorted, allowing a binary search to find the best complement for each\n * left sum.\n *\n * Time Complexity:\n * Generating subset sums for each half takes O(2^{n/2}) time. For each left sum we perform a\n * binary search on the corresponding right list, leading to O(2^{n/2} log 2^{n/2}) overall.\n * Hence the total complexity is O(2^{n/2} * n).\n *\n * Space Complexity:\n * All subset sums are stored, requiring O(2^{n/2}) additional space.\n */\n// class Solution {
//     public int minimumDifference(int[] nums) {
//         int sum = 0;
//         for (int i : nums) {
//             sum += i;
//         }
//         ArrayList<Integer>[] leftSums = new ArrayList[mid + 1];
//         ArrayList<Integer>[] rightSums = new ArrayList[n - mid + 1];

//         for (int i = 0; i <= mid; i++) {
//             leftSums[i] = new ArrayList<>();
//             rightSums[i] = new ArrayList<>();
//         }

//         generate(nums, 0, mid, 0, 0, leftSums);
//         generate(nums, mid, n, 0, 0, rightSums);
//         return recursion(nums, sum, nums.length - 1, 0, 0);
//     }

//     public void generate(int[] nums, int idx, int end, int sum, int chosen, ArrayList<Integer>[] sums) {

//         if (idx == end) {
//             sums[chosen].add(sum);
//             return;
//         }
//         generate(nums, idx + 1, end, sum, chosen, sums);
//         generate(nums, idx + 1, end, sum + nums[idx], chosen + 1, sums);
//     }

//     public int recursion(int[] nums, int totalsum, int idx, int sum, int chosen) {
//         if (chosen == nums.length / 2) {
//             return Math.abs(totalsum - 2 * sum);
//         }
//         if (idx < 0) {
//             if (chosen == nums.length / 2) {
//                 return Math.abs(totalsum - 2 * sum);
//             }
//             return Integer.MAX_VALUE;
//         }
//         int ntake = recursion(nums, totalsum, idx - 1, sum, chosen);
//         int take = recursion(nums, totalsum, idx - 1, sum + nums[idx], chosen + 1);

//         return Math.min(ntake, take);
//     }
// }

import java.util.*;

class Solution {

    public int minimumDifference(int[] nums) {

        int n = nums.length;
        int half = n / 2;

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // sums based on number of elements chosen
        List<List<Integer>> left = new ArrayList<>();
        List<List<Integer>> right = new ArrayList<>();

        for (int i = 0; i <= half; i++) {
            left.add(new ArrayList<>());
            right.add(new ArrayList<>());
        }

        // Generate all subset sums
        generate(nums, 0, half, 0, 0, left);
        generate(nums, half, n, 0, 0, right);

        // Sort right-side sums
        for (List<Integer> list : right) {
            Collections.sort(list);
        }

        int answer = Integer.MAX_VALUE;

        // Choose k elements from left
        for (int k = 0; k <= half; k++) {

            List<Integer> leftValues = left.get(k);

            // We must choose half-k elements from right
            List<Integer> rightValues = right.get(half - k);

            for (int leftSum : leftValues) {

                /*
                 * We want:
                 *
                 * leftSum + rightSum ≈ totalSum / 2
                 *
                 * Therefore:
                 */
                double target = (double) totalSum / 2 - leftSum;

                int pos = binarySearch(rightValues, target);

                // Candidate at insertion position
                if (pos < rightValues.size()) {

                    int rightSum = rightValues.get(pos);

                    int selectedSum = leftSum + rightSum;

                    int difference =
                            Math.abs(totalSum - 2 * selectedSum);

                    answer = Math.min(answer, difference);
                }

                // Candidate just before insertion position
                if (pos > 0) {

                    int rightSum = rightValues.get(pos - 1);

                    int selectedSum = leftSum + rightSum;

                    int difference =
                            Math.abs(totalSum - 2 * selectedSum);

                    answer = Math.min(answer, difference);
                }
            }
        }

        return answer;
    }

    /*
     * Generates all subset sums of nums[start ... end-1].
     *
     * chosen = number of elements selected
     * sum    = sum of selected elements
     */
    private void generate(
            int[] nums,
            int idx,
            int end,
            int sum,
            int chosen,
            List<List<Integer>> sums) {

        if (idx == end) {
            sums.get(chosen).add(sum);
            return;
        }

        // Don't take nums[idx]
        generate(
                nums,
                idx + 1,
                end,
                sum,
                chosen,
                sums
        );

        // Take nums[idx]
        generate(
                nums,
                idx + 1,
                end,
                sum + nums[idx],
                chosen + 1,
                sums
        );
    }

    /*
     * Returns the first position where target can be inserted
     * while maintaining sorted order.
     */
    private int binarySearch(List<Integer> arr, double target) {

        int low = 0;
        int high = arr.size();

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
\n\npublic class Driver {\n    public static void main(String[] args) {\n        Solution sol = new Solution();\n        int[][] testCases = {\n            {1,2,3,4},\n            {5,5,5,5,5,5},\n            {1,6,11,5}\n        };\n        for (int i = 0; i < testCases.length; i++) {\n            int result = sol.minimumDifference(testCases[i]);\n            System.out.println(\"Test case \" + (i+1) + \": \" + result);\n        }\n    }\n}