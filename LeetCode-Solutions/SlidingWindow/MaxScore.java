import java.util.Arrays;
/**
 * Approach: Uses a Sliding Window technique to find the minimum sum of a subarray of size n-k, where n is the total number of card points and k is the number of cards to take. The total sum of all card points minus the minimum sum of the subarray gives the maximum score that can be achieved.
 * Time Complexity: O(n), where n is the number of card points.
 * Space Complexity: O(1), as only a constant amount of space is used.
 */
public class MaxScore {
    class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int tsum = 0;
        int n = cardPoints.length;
        for (int i = 0; i < n; i++) {
            tsum += cardPoints[i];
        }
        if (k == n) {
            return tsum;
        }
        int size = n - k;
        int rt;
        int sum = 0;
        int lt = 0;
        for (rt = 0; rt < size; rt++) {
            sum += cardPoints[rt];
        }
        int min = sum;
        while (rt < n) {
            sum +=cardPoints[rt];
            sum -=cardPoints[lt];
            lt++;
            rt++;
            min = Math.min(min,sum);
        }
        return tsum - min;
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] cardPoints1 = {1, 2, 3, 4, 5, 6, 1};
        int k1 = 3;
        System.out.println("Max Score: " + solution.maxScore(cardPoints1, k1));
        int[] cardPoints2 = {2, 2, 2};
        int k2 = 2;
        System.out.println("Max Score: " + solution.maxScore(cardPoints2, k2));
        int[] cardPoints3 = {9, 7, 7, 9, 7, 7, 9};
        int k3 = 7;
        System.out.println("Max Score: " + solution.maxScore(cardPoints3, k3));
    }
}