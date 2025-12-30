import java.util.Arrays;

/**
 * Approach: Uses a two-pointer technique to match players and trainers. The algorithm sorts both the players and trainers arrays in ascending order, then iterates through the trainers array. If a trainer's skill level is greater than or equal to a player's skill level, the player is matched with the trainer and the player index is incremented.
 * Time Complexity: O(n log n + m log m) due to the sorting of the players and trainers arrays, where n and m are the lengths of the players and trainers arrays respectively.
 * Space Complexity: O(1) if the input arrays are allowed to be modified in-place, otherwise O(n + m) for the sorted arrays.
 */
public class Solution {
    class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int cnt=0;
        int i=0;
        int j=0;
        while(j<trainers.length && i<players.length){
            if(trainers[j]>=players[i]){
                cnt++;
                i++;
            }
            j++;
        }
        return cnt;
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] playersTestCases = {
            {4,7,8},
            {1},
            {2,0,1}
        };
        int[][] trainersTestCases = {
            {8,2,5,8},
            {10},
            {1}
        };
        for (int i = 0; i < playersTestCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ": " + solution.matchPlayersAndTrainers(playersTestCases[i], trainersTestCases[i]));
        }
    }
}