
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class provides a solution to the problem of finding the number of subarrays with exactly k distinct elements.
 * 
 * Approach: 
 * Uses a Sliding Window technique to track the subarrays with at most k distinct elements. 
 * It maintains a LinkedHashMap to store the frequency of each element in the current window. 
 * When the number of distinct elements exceeds k, it slides the window to the right by removing the leftmost element.
 * 
 * Time Complexity: 
 * O(n), where n is the length of the input array, because each element is visited at most twice (once by the right pointer and once by the left pointer).
 * 
 * Space Complexity: 
 * O(n), where n is the length of the input array, because in the worst case, the LinkedHashMap can store up to n elements.
 */
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmostk(nums, k) - atmostk(nums, k - 1);
    }

    public int atmostk(int[] nums, int k) {
        if(k==0) return 0;
        int cnt = 0;
        // HashMap<Integer, Integer> map = new HashMap<>();
        int lt = 0;
        int rt = 0;
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>(16,0.75f,true);
        while (rt < nums.length) {
            if (!map.containsKey(nums[rt]) && map.size() >= k) {
                Map.Entry<Integer,Integer> entry=map.entrySet().iterator().next();
                    lt =entry.getValue()+ 1;
                    map.remove(entry.getKey());
            }
            map.put(nums[rt], rt);
                cnt = cnt + rt - lt + 1;
            // System.out.println(map+" "+"cnt "+cnt+" lt"+lt+" rt"+rt);
            rt++;
        }
        return cnt;
    }
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 1, 2, 3};
        int k1 = 2;
        System.out.println("Number of subarrays with " + k1 + " distinct elements: " + solution.subarraysWithKDistinct(nums1, k1));

        int[] nums2 = {1, 2, 1, 3, 4};
        int k2 = 3;
        System.out.println("Number of subarrays with " + k2 + " distinct elements: " + solution.subarraysWithKDistinct(nums2, k2));

        int[] nums3 = {1, 2, 1, 2, 3, 3, 3};
        int k3 = 2;
        System.out.println("Number of subarrays with " + k3 + " distinct elements: " + solution.subarraysWithKDistinct(nums3, k3));
    }
}
