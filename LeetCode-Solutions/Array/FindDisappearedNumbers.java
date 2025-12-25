import java.util.ArrayList;
import java.util.List;
/**
 * Approach: Uses a boolean array to mark the presence of each number in the input array.
 * Time Complexity: O(n), where n is the length of the input array.
 * Space Complexity: O(n), where n is the length of the input array.
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
             int n=nums.length;
        boolean[] check=new boolean[n+1];
        // System.out.println(Arrays.toString(check));
        for(int i:nums){
           check[i]=true;
            }
            // System.out.println(Arrays.toString(check));
ArrayList<Integer> res=new ArrayList<>(); 
        for(int i=1;i<=n;i++){
            if(!check[i]){
                res.add(i);
            }
        }
        return res;
    }
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {4, 3, 2, 7, 8, 2, 3, 1},
            {1, 1},
            {1, 1, 2}
        };
        for (int[] testCase : testCases) {
            System.out.println("Input: " + java.util.Arrays.toString(testCase));
            System.out.println("Disappeared Numbers: " + solution.findDisappearedNumbers(testCase));
        }
    }
}