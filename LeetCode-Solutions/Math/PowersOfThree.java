import java.lang.Math;
/**
 * Approach: Uses a greedy algorithm to check if a number can be represented as the sum of powers of three.
 * Time Complexity: O(log n) because we are iterating from the highest power of three to the lowest.
 * Space Complexity: O(1) because we are using a constant amount of space.
 */
public class Solution {
    class Solution {
    public boolean checkPowersOfThree(int n) {
        for(int i=16;i>=0;i--){
            int res=(int)Math.pow(3,i);
            if(res==n){
                return true;
            }
            else if(res<n){
                n=n-res;
            }
        }
        return false;
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkPowersOfThree(12)); // true
        System.out.println(solution.checkPowersOfThree(7));  // true
        System.out.println(solution.checkPowersOfThree(21)); // true
    }
}