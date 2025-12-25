
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a solution to the problem of finding error numbers in an array.
 * 
 * Approach: Uses a HashMap to track the frequency of each number in the array.
 * The algorithm iterates over the array, marking the presence of each number in the HashMap.
 * It then iterates over the HashMap to find the number that appears twice (the duplicate) and the number that does not appear (the missing number).
 * 
 * Time Complexity: O(n), where n is the length of the input array.
 * Space Complexity: O(n), where n is the length of the input array.
 * 
 * @author [Your Name]
 * @version [Current Version]
 */
public class Solution {
    class Solution {
    public int[] findErrorNums(int[] nums) {
        // [1,2,3,4,5,6,7,8,9]
        // {0,1,2,3,4,5,6,7,8}
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=1;i<=nums.length;i++){
            map.put(i,0);
        }
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else if(map.containsKey(nums[i])){
                map.put(nums[i],map.getOrDefault(nums[i],1)+1);
            }
        }
        System.out.println(map);
        int[] res=new int[2];
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()==2){
                res[0]=entry.getKey();
            }
            if(entry.getValue()==0){
                res[1]=entry.getKey();
            }
        }
        return res;    
}
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {1, 2, 2, 4},
            {1, 2, 3, 5, 6, 7, 8, 9, 9},
            {1, 1, 2, 3, 4, 5, 6, 7, 8, 9}
        };
        for (int[] testCase : testCases) {
            int[] result = solution.findErrorNums(testCase);
            System.out.println("Test Case: ");
            System.out.println(java.util.Arrays.toString(testCase));
            System.out.println("Result: ");
            System.out.println(java.util.Arrays.toString(result));
        }
    }
}
