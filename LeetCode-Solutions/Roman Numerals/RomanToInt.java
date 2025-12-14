import java.util.HashMap;
import java.util.Map;
/**
 * This class provides a solution to convert Roman numerals to integers.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class Solution {
    /**
     * Converts a Roman numeral to an integer.
     * 
     * Approach: Uses a HashMap to store the Roman numerals and their corresponding integer values. It then iterates over the input string from right to left, adding or subtracting the current value based on whether it is less than the previous value.
     * 
     * Time Complexity: O(n), where n is the length of the input string.
     * Space Complexity: O(1), as the space used does not grow with the size of the input string, only with the number of unique Roman numerals.
     * 
     * @param s the Roman numeral to convert
     * @return the integer equivalent of the Roman numeral
     */
    class Solution {
    public int romanToInt(String s) {
                Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int total = 0;
        int prevValue = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanMap.get(s.charAt(i));

            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }

            prevValue = currentValue;
        }

        return total;
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("III"));  // Output: 3
        System.out.println(solution.romanToInt("IV"));   // Output: 4
        System.out.println(solution.romanToInt("IX"));   // Output: 9
        System.out.println(solution.romanToInt("LVIII")); // Output: 58
        System.out.println(solution.romanToInt("MCMXCIV")); // Output: 1994
    }
}