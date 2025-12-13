import java.math.BigInteger;

/**
 * The myAtoi function converts a string to a 32-bit signed integer (similar to C/C++'s atoi).
 *
 * This implementation first performs necessary cleaning (trimming whitespace, identifying the sign),
 * extracts the numerical sequence, and then uses BigInteger to safely handle potential integer
 * overflow/underflow before clamping the result to the 32-bit integer range [Integer.MIN_VALUE, Integer.MAX_VALUE].
 *
 * Time Complexity: O(N)
 * The algorithm involves iterating through the input string 's' once for trimming and parsing the numerical part.
 * N is the length of the input string s. The BigInteger operations on the resulting
 * numerical string (which is limited to a small number of digits, usually <= 12) are considered O(1) complexity relative to the string length N.
 *
 * Space Complexity: O(N)
 * Space is used primarily to store the trimmed string and temporary StringBuilders (O(N)).
 * While the significant numerical part (sbr) is O(1) in size due to integer limits, the initial string manipulation
 * necessitates O(N) space complexity overall.
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

class Driver {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Standard number with leading spaces, sign, and trailing text
        String s1 = "   -4193 with words";
        int result1 = sol.myAtoi(s1);
        System.out.println("Input: \"" + s1 + "\", Output: " + result1 + " (Expected: -4193)");

        // Test Case 2: Positive overflow
        String s2 = "20000000000000000000";
        int result2 = sol.myAtoi(s2);
        System.out.println("Input: \"" + s2 + "\", Output: " + result2 + " (Expected: " + Integer.MAX_VALUE + ")");

        // Test Case 3: Leading zeros and negative sign
        String s3 = "-00123";
        int result3 = sol.myAtoi(s3);
        System.out.println("Input: \"" + s3 + "\", Output: " + result3 + " (Expected: -123)");
        
        // Test Case 4: Only whitespace
        String s4 = "   ";
        int result4 = sol.myAtoi(s4);
        System.out.println("Input: \"" + s4 + "\", Output: " + result4 + " (Expected: 0)");
    }
}