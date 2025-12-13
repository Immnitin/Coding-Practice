import java.util.Stack;
import java.util.Arrays;

/**
 * Problem Category: Stack Simulation / Array Processing
 * Method: asteroidCollision(int[] asteroids)
 *
 * Analysis of User Approach:
 * The user implements the classic Asteroid Collision problem (LeetCode 735) using a Stack structure.
 * The core logic simulates collisions, which only occur when the stack top represents an asteroid
 * moving right (positive) and the current asteroid is moving left (negative).
 * The implementation correctly identifies the three collision outcomes: mutual destruction (handled via cnt2),
 * stack top survival (handled via cnt3), or current asteroid survival (leading to stack pops until collision stops).
 * The remaining elements in the stack represent the asteroids that survived all collisions.
 *
 * Time Complexity: O(N)
 * Where N is the number of asteroids. Although there is a nested while loop, each asteroid is processed in an amortized O(1) manner.
 * An asteroid is pushed onto the stack exactly once and can be popped at most once. Therefore, the total number of stack operations is linear with respect to N.
 *
 * Space Complexity: O(N)
 * In the worst-case scenario (e.g., no collisions occurring, or all survivors), the stack will hold up to N elements.
 */
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
       Stack<Integer> stk=new Stack<>();
       int cnt1=0,cnt2=0,cnt3=0;
       for(int i=0;i<asteroids.length;i++){
        int curr=asteroids[i];
        while(!stk.isEmpty() &&stk.peek()>=0 && curr<=0){
             if(Math.abs(curr)==Math.abs(stk.peek())){
                cnt2++;
                stk.push(curr);
                stk.pop();
                if(!stk.isEmpty())
                stk.pop();
                break;
            }
            else if(Math.abs(stk.peek())>Math.abs(curr)){
                cnt3++;
                break;
            }
            // else if(stk.peek()<Math.abs(curr))
            else    stk.pop();
        }
        if(cnt2>0|| cnt3>0){
            cnt2=0;
            cnt3=0;
            continue;
        }
        stk.push(asteroids[i]);
       }
       int[] arr=new int[stk.size()];
       int j=stk.size()-1;
       while(!stk.isEmpty() && j>=0){
        arr[j]=stk.pop();
        j--;
       }
       return arr;
    }
}

public class AsteroidCollisionDriver {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard collision (Right mover survives 10 > |-5|)
        int[] input1 = {5, 10, -5};
        int[] result1 = solution.asteroidCollision(input1);
        System.out.println("Input: " + Arrays.toString(input1));
        System.out.println("Output: " + Arrays.toString(result1) + " | Expected: [5, 10]");
        System.out.println("----------------------------------");

        // Test Case 2: Mutual destruction (8 vs -8)
        int[] input2 = {8, -8};
        int[] result2 = solution.asteroidCollision(input2);
        System.out.println("Input: " + Arrays.toString(input2));
        System.out.println("Output: " + Arrays.toString(result2) + " | Expected: []");
        System.out.println("----------------------------------");

        // Test Case 3: No collisions possible (directions are compatible or separated)
        int[] input3 = {-2, -1, 1, 2};
        int[] result3 = solution.asteroidCollision(input3);
        System.out.println("Input: " + Arrays.toString(input3));
        System.out.println("Output: " + Arrays.toString(result3) + " | Expected: [-2, -1, 1, 2]");
        System.out.println("----------------------------------");

        // Test Case 4: Complex collision chain (10 vs 2 vs -5) -> 2 destroyed, then -5 destroyed by 10.
        int[] input4 = {10, 2, -5};
        int[] result4 = solution.asteroidCollision(input4);
        System.out.println("Input: " + Arrays.toString(input4));
        System.out.println("Output: " + Arrays.toString(result4) + " | Expected: [10]");
        System.out.println("----------------------------------");
    }
}