import java.util.Arrays;
/**
 * Approach: Uses a greedy algorithm to track the number of 5, 10, and 20 dollar bills.
 * The algorithm iterates through each bill and attempts to make change using the available bills.
 * Time Complexity: O(n), where n is the number of bills.
 * Space Complexity: O(1), as the space used does not grow with the size of the input.
 */
class Solution {
    public boolean lemonadeChange(int[] bills) {
    int cnt5=0;
    int cnt10=0;
    int cnt20=0;
    for(int i=0;i<bills.length;i++){
        if(bills[i]==5){cnt5++;}
        else if(bills[i]==10){cnt10++;}
        else if(bills[i]==20){cnt20++;}
        // System.out.println("cnt5 "+cnt5+" cnt10 "+cnt10+" cnt20 "+cnt20);
        if(bills[i]>5){
            int change=bills[i]-5;
            while(change>=5){
                if(change>=20 && cnt20>0){
                    // if(cnt20<=0)
                    //     continue;
                    //     // return false;
                    // else 
                    // {
                        cnt20--;
                    change=change-20;
                    // }
                }
                else if(change>=10 && cnt10>0){
                    // if(cnt10<=0)
                        // continue;
                        // return false;
                    // else 
                    // {
                        cnt10--;
                    change=change-10;
                    // }
                }
                else if(change>=5){
                    if(cnt5<=0)
                        return false;
                    else 
                    {cnt5--;
                    change=change-5;}
                }
            // System.out.println("bills[i]>5 cnt5 "+cnt5+" cnt10 "+cnt10+" cnt20 "+cnt20);
            }
                
        }
        }
        if(cnt5<0 || cnt10<0 || cnt20<0){
            return false;
        }
     return true;   
    }
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {5, 5, 5, 10, 20},
            {5, 5, 10},
            {10, 10}
        };
        for (int[] testCase : testCases) {
            System.out.println("Test Case: " + Arrays.toString(testCase) + ", Result: " + solution.lemonadeChange(testCase));
        }
    }
}