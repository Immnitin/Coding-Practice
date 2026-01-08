import java.util.*;

/**
 * This class provides a solution to the Maximum Path Sum problem in a binary tree.
 * 
 * Approach: 
 * The solution uses a recursive depth-first search (DFS) approach to calculate the maximum path sum.
 * It maintains a global maximum path sum and updates it whenever a larger path sum is found.
 * The helper function calculates the maximum path sum for each subtree and returns the maximum path sum that includes the current node.
 * 
 * Time Complexity: 
 * The time complexity of this solution is O(N), where N is the number of nodes in the binary tree.
 * This is because each node is visited once during the DFS traversal.
 * 
 * Space Complexity: 
 * The space complexity of this solution is O(H), where H is the height of the binary tree.
 * This is because the maximum depth of the recursive call stack is equal to the height of the tree.
 * In the worst case, the tree is skewed and the height is equal to the number of nodes, resulting in a space complexity of O(N).
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max=new int[1];
        max[0]=Integer.MIN_VALUE;
        helper(root,max);
        return max[0];
    }
    public int helper(TreeNode root,int[] max){
        if(root==null){
            return 0;
        }
        int ltsum=Math.max(0,helper(root.left,max));
        int rtsum=Math.max(0,helper(root.right,max));
        max[0]=Math.max(max[0],root.val+ltsum+rtsum);
        return root.val+Math.max(ltsum,rtsum);
    }
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1:
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println("Max Path Sum: " + solution.maxPathSum(root1));
        
        // Test case 2:
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
        System.out.println("Max Path Sum: " + solution.maxPathSum(root2));
        
        // Test case 3:
        TreeNode root3 = new TreeNode(-15);
        root3.left = new TreeNode(-10);
        root3.right = new TreeNode(5);
        System.out.println("Max Path Sum: " + solution.maxPathSum(root3));
    }
}
