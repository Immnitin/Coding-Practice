import java.util.*;
/**
 * This class calculates the maximum depth of a binary tree.
 * 
 * @author [Your Name]
 * @version 1.0
 * @since [Date]
 *
 * Approach: Uses a recursive depth-first search (DFS) approach to traverse the binary tree and calculate its maximum depth.
 * Time Complexity: O(N), where N is the number of nodes in the binary tree, since we visit each node once.
 * Space Complexity: O(H), where H is the height of the binary tree, due to the recursive call stack.
 */
public class MaxDepthOfBinaryTree {
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
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int lt=maxDepth(root.left);
        int rt=maxDepth(root.right);
        return 1+Math.max(lt,rt);
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test case 1: Balanced binary tree
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("Max depth of balanced binary tree: " + solution.maxDepth(root1));
        
        // Test case 2: Unbalanced binary tree
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);
        root2.right.right.right = new TreeNode(4);
        System.out.println("Max depth of unbalanced binary tree: " + solution.maxDepth(root2));
        
        // Test case 3: Empty binary tree
        TreeNode root3 = null;
        System.out.println("Max depth of empty binary tree: " + solution.maxDepth(root3));
    }
}