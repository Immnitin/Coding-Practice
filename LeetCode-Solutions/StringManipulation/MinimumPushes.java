import java.util.Arrays;

/**
 * This class provides a solution to the Minimum Pushes problem.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class MinimumPushes {
    /**
     * This method calculates the minimum number of pushes required to arrange the characters in the given word.
     * 
     * Approach: Uses a frequency array to count the occurrences of each character, sorts the array, and then reverses it. The minimum number of pushes is calculated by multiplying the frequency of each character by its position in the reversed array divided by 8 plus 1.
     * 
     * Time Complexity: O(n log n) due to the sorting operation, where n is the size of the frequency array (26 in this case).
     * Space Complexity: O(1) as the space used does not grow with the size of the input, excluding the space required for the input and output.
     * 
     * @param word the input word
     * @return the minimum number of pushes required
     */
    class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            freq[idx]++;
        }

        Arrays.sort(freq);

        int left = 0;
        int right = freq.length - 1;

        while (left < right) {
            int temp = freq[left];
            freq[left] = freq[right];
            freq[right] = temp;

            left++;
            right--;
        }

        int cnt=0;
        for(int i=0;i<freq.length;i++)
            cnt+=freq[i]*((i/8)+1);
    return cnt;
    }
}
}

class Driver {
    public static void main(String[] args) {
        MinimumPushes solution = new MinimumPushes();
        System.out.println("Minimum pushes for 'abc': " + solution.minimumPushes("abc"));
        System.out.println("Minimum pushes for 'aaaa': " + solution.minimumPushes("aaaa"));
        System.out.println("Minimum pushes for 'abcdefghijklmnopqrstuvwxyz': " + solution.minimumPushes("abcdefghijklmnopqrstuvwxyz"));
    }
}