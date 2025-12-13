import java.util.*;

/**
 * Palindrome Partitioning (Backtracking)
 * 
 * This class implements a solution to find all possible palindrome partitioning of a given string using Depth First Search (DFS) / Backtracking.
 *
 * Time Complexity Analysis:
 * The complexity of Palindrome Partitioning is inherently exponential. In the worst case (e.g., a string of all the same character), the number of partitions can reach O(2^N). 
 * Since the approach re-checks palindromes and copies the resulting lists, the overall time complexity is approximated as O(N * 2^N), where N is the length of the string.
 *
 * Space Complexity Analysis:
 * The space complexity is dominated by the storage required for the output results. 
 * Since there can be O(2^N) results, and each result list holds up to N strings, the space required for the output is O(N * 2^N).
 * Additionally, the recursion stack depth goes up to O(N).
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<String> res1=new ArrayList<>();
        List<List<String>> res=new ArrayList<>();
        substring(s,0,res1,res);
        return res;
    }
    public void substring(String s, int startIdx, List<String> res1, List<List<String>> res){
        if(startIdx==s.length()){
            res.add(new ArrayList<>(res1));
        }
        for(int i=startIdx;i<s.length();i++){
            String ss=s.substring(startIdx,i+1);
            if(palindrome(ss)){
                res1.add(ss);
                substring(s,i+1,res1,res);
                res1.remove(res1.size()-1);
            }
        }
    }
    public boolean palindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

class Driver {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println("--- Test Case 1: s = 'aab' ---");
        String s1 = "aab";
        List<List<String>> result1 = sol.partition(s1);
        System.out.println("Input: " + s1);
        System.out.println("Output:");
        printResults(result1); // Expected: [[a, a, b], [aa, b]]

        System.out.println("
--- Test Case 2: s = 'a' ---");
        String s2 = "a";
        List<List<String>> result2 = sol.partition(s2);
        System.out.println("Input: " + s2);
        System.out.println("Output:");
        printResults(result2); // Expected: [[a]]

        System.out.println("
--- Test Case 3: s = 'aba' ---");
        String s3 = "aba";
        List<List<String>> result3 = sol.partition(s3);
        System.out.println("Input: " + s3);
        System.out.println("Output:");
        printResults(result3); // Expected: [[a, b, a], [aba]]

        System.out.println("
--- Test Case 4: s = 'racecar' ---");
        String s4 = "racecar";
        List<List<String>> result4 = sol.partition(s4);
        System.out.println("Input: " + s4);
        System.out.println("Output: (Partial display)");
        printResults(result4);
    }

    private static void printResults(List<List<String>> results) {
        int count = 0;
        for (List<String> list : results) {
            if (count < 10) { // Limit output for large cases
                System.out.println(list);
            }
            count++;
        }
        if (count > 10) {
             System.out.println("[... " + (count - 10) + " more results hidden]");
        }
    }
}