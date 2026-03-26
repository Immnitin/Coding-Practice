import java.util.*;
/**
 * This class checks if a given binary string contains at most one segment of consecutive ones.
 * <p>
 * Approach: The algorithm iterates through the string, checking for transitions from '1' to '0'. If such a transition is found and a segment has already been counted, the method returns false. Otherwise, it counts the segment and continues checking the rest of the string.
 * <p>
 * Time Complexity: O(n), where n is the length of the input string, because we are doing a constant amount of work for each character in the string.
 * <p>
 * Space Complexity: O(1), because we are using a constant amount of space to store our variables, regardless of the size of the input string.
 */
public class CheckOnesSegment {
    class Solution {
    public boolean checkOnesSegment(String s) {
        int cnt=0;
        int seg=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1' && i+1<s.length() ){
                if(seg>=1){
                    return false;
                }
                if(s.charAt(i+1)!='1'){
                seg++;
                }
            }
                 if(seg>=1 && s.charAt(s.length()-1)=='1'){
                return false;
            }
           
        }
        return true;
    }
}
}

class Driver {
    public static void main(String[] args) {
        CheckOnesSegment solution = new CheckOnesSegment();
        System.out.println(solution.checkOnesSegment("110")); // false
        System.out.println(solution.checkOnesSegment("111")); // true
        System.out.println(solution.checkOnesSegment("000")); // true
    }
}