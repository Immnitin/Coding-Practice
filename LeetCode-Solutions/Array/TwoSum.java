import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
/**
 * Approach: Uses a HashMap to store the indices of the elements in the array. It then iterates over the array to find the two elements that add up to the target sum.
 * Time Complexity: O(n), where n is the number of elements in the array.
 * Space Complexity: O(n), where n is the number of unique elements in the array.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
    //    int array[]=new int[nums.length];
    //     for(int i=0;i<=nums.length-1;i++)
    //     {for(int j=i+1;j<=nums.length-1;j++)
    //     {   if(nums[i]+nums[j]==target)
    //         {return new int[]{i,j};
    //         //array[i]=i;
    //         //array[j]=j;
    //                 }
    //         }
    //     }
    //     //return array;
    //     return new int[]{};
    int[] res=new int[2]; 
    HashMap<Integer,List<Integer>> map=new HashMap<>(); 
    for(int i=0;i<nums.length;i++){
        if(!map.containsKey(nums[i])){
            map.put(nums[i],new ArrayList<>());
        }
        map.get(nums[i]).add(i);
    }
    for(int j=0;j<nums.length;j++){
        if(map.containsKey(target-nums[j])){
            if(nums[j]==target-nums[j] && map.get(target-nums[j]).size()>=2){
                res[0]=map.get(target-nums[j]).get(0);
                res[1]=map.get(target-nums[j]).get(1); 
            }
            if(j!=map.get(target-nums[j]).get(0))
            {res[0]=j;
            res[1]=map.get(target-nums[j]).get(0);
            break;
            }
            }
    }
     return res;
    }
   
}
public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {2, 7, 11, 15},
            {3, 2, 4},
            {3, 3}
        };
        int[] targets = {9, 6, 6};
        for (int i = 0; i < testCases.length; i++) {
            int[] result = solution.twoSum(testCases[i], targets[i]);
            System.out.println("Test Case " + (i + 1) + ": " + java.util.Arrays.toString(result));
        }
    }
}