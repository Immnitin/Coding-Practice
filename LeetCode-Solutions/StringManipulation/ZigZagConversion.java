/**
 * Problem: ZigZag Conversion
 * Category: String Manipulation
 *
 * This problem asks us to convert a given string into a zigzag pattern on a specified number of rows,
 * and then read the string row by row to produce the final converted string.
 *
 * The provided user solution implements a direct traversal approach. It iterates through each row (idx)
 * and calculates the necessary jumping steps to pick characters that fall onto that specific row in the zigzag pattern.
 * The jump distance (k) is 2 * (numRows - 1), but for inner rows, the jump alternates between two values
 * determined by the row index.
 *
 * Jumps Calculation:
 * - Row 0 and Row numRows-1: Fixed jump distance (k).
 * - Inner Rows: Alternating jumps (k - 2*idx) and (2*idx).
 */
public class ZigZagConversionDriver {

    class Solution {
    public String convert(String s, int numRows) {
        int k=2*(numRows-1);
  int idx=0;
  StringBuilder st=new StringBuilder("");
  if(s.length()==1 || numRows==1 || s.length()<=numRows){
    return s;
  }
  while(idx<numRows){
     if(idx==0|| idx==numRows-1){
      int count=k;
      int j=count;
      st.append(s.charAt(idx));
       while(idx+j<s.length()){
        //  System.out.print("hi ");
         st.append(s.charAt(idx+j));
         j+=count;
       }
       idx++;
     }
     else{
       int count=k-(2*idx);
       int j=count;
       st.append(s.charAt(idx));
       while(idx+j<s.length()){
         st.append(s.charAt(idx+j));
         count=k-count;
         j+=count;
       }
       idx++;
      // i++;
     }
  }
  return st.toString();
    }
}

    /**
     * Time Complexity Analysis:
     * O(N), where N is the length of the input string s.
     * The algorithm ensures that every character of the string s is visited and appended to the StringBuilder exactly once.
     * The jumping logic ensures efficient traversal without redundant checks.
     *
     * Space Complexity Analysis:
     * O(N), where N is the length of the input string s.
     * This space is used to store the resulting converted string in the StringBuilder.
     */
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("--- ZigZag Conversion Test Cases ---");

        // Test Case 1: Standard ZigZag (3 rows)
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        String result1 = sol.convert(s1, numRows1);
        String expected1 = "PAHNAPLSIIGYIR";
        System.out.println("Test 1 Input: \"" + s1 + "\", Rows: " + numRows1);
        System.out.println("Result:   \"" + result1 + "\"");
        System.out.println("Expected: \"" + expected1 + "\"");
        System.out.println("Status: " + (result1.equals(expected1) ? "PASS" : "FAIL"));
        System.out.println("-------------------------");

        // Test Case 2: 4 rows
        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        String result2 = sol.convert(s2, numRows2);
        String expected2 = "PINALSIGYAHRPI";
        System.out.println("Test 2 Input: \"" + s2 + "\", Rows: " + numRows2);
        System.out.println("Result:   \"" + result2 + "\"");
        System.out.println("Expected: \"" + expected2 + "\"");
        System.out.println("Status: " + (result2.equals(expected2) ? "PASS" : "FAIL"));
        System.out.println("-------------------------");

        // Test Case 3: Edge Case (1 row)
        String s3 = "A";
        int numRows3 = 1;
        String result3 = sol.convert(s3, numRows3);
        String expected3 = "A";
        System.out.println("Test 3 Input: \"" + s3 + "\", Rows: " + numRows3);
        System.out.println("Result:   \"" + result3 + "\"");
        System.out.println("Expected: \"" + expected3 + "\"");
        System.out.println("Status: " + (result3.equals(expected3) ? "PASS" : "FAIL"));
        System.out.println("-------------------------");
    }
}