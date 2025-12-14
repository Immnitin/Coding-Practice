import java.math.BigInteger;

/**
 * This class provides a method to convert a string to a 32-bit signed integer.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class Solution {
    /**
     * Converts a string to a 32-bit signed integer.
     * 
     * Approach: This method uses a StringBuilder to trim and parse the input string.
     * It handles leading zeros, signs, and non-digit characters. It also checks for
     * overflow and underflow by comparing the parsed number with the minimum and maximum
     * integer values.
     * 
     * Time Complexity: O(n), where n is the length of the input string.
     * Space Complexity: O(n), where n is the length of the input string.
     * 
     * @param s the input string to be converted
     * @return the converted 32-bit signed integer
     */
    // import java.math.BigInteger;
// class Solution {
//     public int myAtoi(String s) {
//         if(s.length()==0){
//             return 0;
//         }
//          StringBuilder sb=new StringBuilder(s.trim());
//         char sign=' ';
//         if(sb.charAt(0)=='+' || sb.charAt(0)=='-'){
//         sign= sb.charAt(0);
//         sb.deleteCharAt(0);
//         }
//         StringBuilder sbr=new StringBuilder();
//         for(int i=0;i<sb.length();i++){
//             if(sb.charAt(i)=='0'){
//                 continue;
//             }
//               else if(!Character.isDigit​(sb.charAt(i))){
//                 break;
//             }
//             else if(Character.isDigit​(sb.charAt(i))){
//                 sbr.append(sb.charAt(i));
//             }
//         }
//         // System.out.println("sbr "+sbr);
//         if(sbr.length()==0){
//             return 0;
//         }
//         BigInteger num=new BigInteger(sbr.toString());
//         BigInteger signedNum = (sign == '-') ? num.negate() : num;
//         // System.out.println("num "+num);
//       int res;
// if(signedNum.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0){
//     res = Integer.MIN_VALUE;
// } else if(signedNum.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0){
//     res = Integer.MAX_VALUE;
// } else {
//     res = signedNum.intValue(); 
// }        
//         return res;
//     }
// }


import java.math.BigInteger;

class Solution {
    public int myAtoi(String s) {
        // Initial check for null or empty string remains the same.
        if (s == null || s.length() == 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder(s.trim());

        // FIX #1: Handle cases where the string is empty after trimming (e.g., "   ").
        if (sb.length() == 0) {
            return 0;
        }

        char sign = ' ';
        if (sb.charAt(0) == '+' || sb.charAt(0) == '-') {
            sign = sb.charAt(0);
            sb.deleteCharAt(0);
        }

        StringBuilder sbr = new StringBuilder();
        // FIX #2: Use a flag to properly handle leading zeros.
        boolean leadingZero = true; 

        for (int i = 0; i < sb.length(); i++) {
            char currentChar = sb.charAt(i);

            if (Character.isDigit(currentChar)) {
                // If it's a non-zero digit, start recording.
                if (currentChar != '0') {
                    leadingZero = false;
                    sbr.append(currentChar);
                } 
                // If it's a zero, only record it if we are past the leading zeros.
                else if (!leadingZero) {
                    sbr.append(currentChar);
                }
            } else {
                // If we see a non-digit, we're done.
                break;
            }
        }

        // The rest of your logic for BigInteger and clamping is perfectly fine.
        if (sbr.length() == 0) {
            return 0;
        }
        
        // Prevent BigInteger from crashing on extremely long numbers that are valid digits
        // e.g., a string with 200 digits. We only need up to ~11 for an int.
        if (sbr.length() > 12) {
            if (sign == '-') return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }


        BigInteger num = new BigInteger(sbr.toString());
        BigInteger signedNum = (sign == '-') ? num.negate() : num;

        int res;
        if (signedNum.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
            res = Integer.MIN_VALUE;
        } else if (signedNum.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            res = Integer.MAX_VALUE;
        } else {
            res = signedNum.intValue();
        }
        return res;
    }
}
}

/**
 * Driver class to test the string to integer conversion method.
 */
public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("42"));  // Output: 42
        System.out.println(solution.myAtoi("   -42"));  // Output: -42
        System.out.println(solution.myAtoi("4193 with words"));  // Output: 4193
    }
}