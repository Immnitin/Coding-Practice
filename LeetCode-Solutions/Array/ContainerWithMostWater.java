import java.util.List;
/**
 * Approach: Uses a Two-Pointer Technique to track the maximum area between two lines.
 * The algorithm starts from both ends of the array and moves the pointer with the smaller height towards the center.
 * Time Complexity: O(n), where n is the number of elements in the height array.
 * Space Complexity: O(1), as only a constant amount of space is used.
 */
class Solution:
    def maxArea(self, height: List[int]) -> int:
        l,r,m=0,len(height)-1,0
        while(l<r):
            area=min(height[l],height[r])*(r-l)
            m=max(area,m)
            if(height[l]<height[r]):
                l+=1
            else:
                r-=1
        return m
        

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testCases = {
            {1,8,6,2,5,4,8,3,7},
            {1,1},
            {4,3,2,1,4}
        };
        for (int[] testCase : testCases) {
            System.out.println("Max Area: " + solution.maxArea(testCase));
        }
    }
}