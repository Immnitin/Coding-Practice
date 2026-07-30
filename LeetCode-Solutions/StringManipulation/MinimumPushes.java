import java.util.Scanner;
/**
 * This class provides a solution to calculate the minimum pushes required.
 * <p>
 * Approach: Uses a simple iterative approach to calculate the minimum pushes required.
 * The algorithm works by subtracting 8 from the length of the word in each iteration and incrementing the push count accordingly.
 * <p>
 * Time Complexity: O(n), where n is the length of the word.
 * <p>
 * Space Complexity: O(1), as it uses a constant amount of space.
 */
public class Solution {
    class Solution {
    public int minimumPushes(String word) {
        int k=1;
        int len=word.length();
        int cnt=0;
        if(word.length()<=8){
            return word.length();
        }
        while(len-8>=0){
            cnt+=8*k;
            len=len-8;
            k++;
        }
        if(len>0){
            cnt+=k*len;
        }
        return cnt;
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Test Case 1: " + solution.minimumPushes("abcdefghij"));
        System.out.println("Test Case 2: " + solution.minimumPushes("abcdefghabcdefgh"));
        System.out.println("Test Case 3: " + solution.minimumPushes("abcdefghabcdefghabcdefgh"));
    }
}