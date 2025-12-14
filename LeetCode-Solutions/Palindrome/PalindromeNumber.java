import java.util.Scanner;
/**
 * Approach: Uses a simple iterative approach to reverse the integer and compare it with the original number.
 * Time Complexity: O(log n), where n is the input number, because we are effectively doing a constant amount of work for each digit in the number.
 * Space Complexity: O(1), because we are using a constant amount of space to store the reversed number and other variables.
 */
class Solution {
    public boolean isPalindrome(int x) {
        int b=x;
        int re=0;
        int i=1;
        while(x>0){
        re=re*10+x%10;
        //System.out.println(re);
        i++;
        x=x/10;    
        }
        if(re==b){
            return true;
        }
        else
        return false;
    }
}
public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121)); // true
        System.out.println(solution.isPalindrome(123)); // false
        System.out.println(solution.isPalindrome(12321)); // true
    }
}