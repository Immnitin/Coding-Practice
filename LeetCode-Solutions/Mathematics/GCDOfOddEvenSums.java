import java.util.Scanner;
/**
 * This class calculates the GCD of the sum of odd numbers and the sum of even numbers up to n.
 * <p>
 * Approach: Uses the Euclidean algorithm to find the GCD of two numbers, where the numbers are the sum of squares of n (sum of odd numbers) and the sum of the first n natural numbers (sum of even numbers).
 * <p>
 * Time Complexity: O(log min(n, m)) where n and m are the two input numbers for the GCD calculation.
 * <p>
 * Space Complexity: O(log min(n, m)) due to recursive call stack.
 */
class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumod=n*n;
        int sumeve=n*(n+1);
        return gcd(sumod,sumeve);
    }
    //This is the Euclidiean formula for finding the gcd between both the numbers 
    public int gcd(int n, int m){
        if(m==0) return n;
        return gcd(m,n%m);
    }
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("GCD of odd and even sums for n = 5: " + solution.gcdOfOddEvenSums(5));
        System.out.println("GCD of odd and even sums for n = 10: " + solution.gcdOfOddEvenSums(10));
        System.out.println("GCD of odd and even sums for n = 15: " + solution.gcdOfOddEvenSums(15));
    }
}