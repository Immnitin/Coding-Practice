import java.util.Deque;
import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * This class provides a solution to the problem of finding the minimum number of operations required to make all elements in an array distinct.
 * 
 * @author [Your Name]
 */
public class Solution {
    /**
     * This method calculates the minimum number of operations required to make all elements in an array distinct.
     * 
     * Approach: Uses a HashSet to track unique elements and a Deque to track the indices of elements. It iterates over the array, adding elements to the set and deque. If an element is already in the set, it checks the deque and updates the count of operations accordingly.
     * 
     * Time Complexity: O(n), where n is the length of the input array.
     * Space Complexity: O(n), where n is the length of the input array.
     * 
     * @param nums the input array
     * @return the minimum number of operations required
     */
    // class Solution {
//     public int minOperations(int[] nums) {
//         Deque<Integer> dq=new ArrayDeque<>();
//         HashSet<Integer> set=new HashSet<>();
//         int rt=0;
//         int lt=0;
//         int cnt=0;
//         while(rt<nums.length){
//             if(!set.contains(nums[rt])){
//                 set.add(nums[rt]);
//             }
//             else if(set.contains(nums[rt])){
//                 if(lt>=nums.length-3){
//                     if(nums[lt]==nums[lt+1] || nums[lt+1]==nums[lt+2] || nums[lt]==nums[lt+2]){
//                         cnt++;
//                     }
//                 }
//                     else if(rt-lt<=2){
//                         cnt++;
//                     }
//                 else{
//                     int i=0;
//                     while(!dq.isEmpty() && lt<nums.length && nums[dq.peekLast()]!=nums[rt]){
//                     set.remove(dq.pollLast());
//                     lt++;
//                     i++;
//                     // if(i==3){
//                     //     cnt++;
//                     //     i=0;
//                     // }
//                 }
//                     lt++;
//                 cnt+=(int)(i+1)/3;
                    
//                 }
//             }
//             dq.offerFirst(rt);
//             rt++;
//         }
//         return cnt;
//         }
//     }

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        boolean[] suffixDistinct = new boolean[n + 1];
        suffixDistinct[n] = true; 

        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> dups = new HashSet<>();

        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i];
            if (!seen.add(x)) {
                dups.add(x);
            }
            suffixDistinct[i] = dups.isEmpty();
        }

        int t = 0;
        while (true) {
            int start = 3 * t;
            if (start >= n) return t;           
            if (suffixDistinct[start]) return t; 
            t++;
        }
    }
}

}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {1, 1, 1};
        int[] test2 = {1, 2, 3};
        int[] test3 = {1, 1, 2, 2, 3, 3};
        System.out.println("Test 1: " + solution.minOperations(test1));
        System.out.println("Test 2: " + solution.minOperations(test2));
        System.out.println("Test 3: " + solution.minOperations(test3));
    }
}