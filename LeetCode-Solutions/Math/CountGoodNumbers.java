import java.lang.Math;
/**
 * Approach: Uses the concept of modular exponentiation to efficiently calculate the power of a number modulo MOD. The countGoodNumbers function calculates the number of good numbers in the range [1, n] by counting the number of even and odd positions and then using the properties of modular arithmetic to calculate the result.
 * Time Complexity: O(log(n)) due to the recursive nature of the pow function, which reduces the problem size by half in each recursive call.
 * Space Complexity: O(log(n)) due to the recursive call stack of the pow function.
 */
class Solution {
    long MOD = 1000000007L;

    public int countGoodNumbers(long n) {
        long evepos = (n + 1) / 2;
        long oddpos = n / 2;
        long ans =(pow(5, evepos) * pow(4, oddpos)) % MOD;
        return (int) ans;

    }

    public long pow(int base, long pos) {
        if (pos == 0) {
            return 1;
        }
        if (pos == 1) {
            return base;
        }
        long half = pow(base, pos / 2);
        if (pos % 2 == 0) {
            return (half * half) % MOD;
        } else {
            return ((( half * half) % MOD)*base) % MOD;
        }
    }

}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countGoodNumbers(3));
        System.out.println(solution.countGoodNumbers(5));
        System.out.println(solution.countGoodNumbers(10));
    }
}