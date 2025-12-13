import java.util.*;

/**
 * Letter Combinations of a Phone Number
 * 
 * Time Complexity: O(N * 4^N)
 * Where N is the length of the input digits string. 
 * Since the maximum number of letters associated with any digit (like '7' or '9') is 4, 
 * the total number of combinations generated is proportional to 4^N.
 * We multiply by N because constructing and copying the resulting string (which has length N) 
 * takes O(N) time for each of the 4^N results.
 * 
 * Space Complexity: O(N * 4^N)
 * This complexity is dominated by the storage required for the output list (res). 
 * We store 4^N strings, each of length N. The recursion stack depth adds O(N) overhead.
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map=new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        combinations(digits,0,res,sb,map);
        return res;
    }

    public void combinations(String digits,int idx,List<String> res, StringBuilder sb,
    HashMap<Character,String> map ){
        if(sb.length()==digits.length()){
            res.add(sb.toString());
            return;
        }
        char num=digits.charAt(idx);
        char[] letters=map.get(num).toCharArray();
        for(char c: letters){
            sb.append(c+"");
            combinations(digits,idx+1,res,sb,map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

class Driver {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Standard input "23"
        String input1 = "23";
        List<String> result1 = sol.letterCombinations(input1);
        System.out.println("Input: \"" + input1 + "\"");
        System.out.println("Output: " + result1);
        // Expected size: 9

        // Test Case 2: Single digit "4"
        String input2 = "4";
        List<String> result2 = sol.letterCombinations(input2);
        System.out.println("\nInput: \"" + input2 + "\"");
        System.out.println("Output: " + result2);
        // Expected: [g, h, i]

        // Test Case 3: Edge case - Empty string
        String input3 = "";
        List<String> result3 = sol.letterCombinations(input3);
        System.out.println("\nInput: \"" + input3 + "\"");
        System.out.println("Output: " + result3);
        // Expected: []
    }
}