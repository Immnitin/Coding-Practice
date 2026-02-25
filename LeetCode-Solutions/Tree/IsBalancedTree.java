import java.util.*;

/**
 * This class checks if a binary tree is balanced.
 * 
 * Approach: 
 * Uses a recursive height calculation method to check if a binary tree is balanced.
 * The height of a tree is the number of edges on the longest path from the root to a leaf.
 * A tree is balanced if the absolute difference between the heights of its left and right subtrees does not exceed 1 for all nodes.
 * 
 * Time Complexity: 
 * O(n), where n is the number of nodes in the tree, since we visit each node once.
 * 
 * Space Complexity: 
 * O(h), where h is the height of the tree, due to the recursive call stack.
 * In the worst case, the tree is skewed and h = n, resulting in O(n) space complexity.
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
    public boolean isBalanced(TreeNode root) {
      if(height(root)==-1){
      return false;
      }
      return true;
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lt=height(root.left);
        if(lt==-1){
            return -1;
        }
        int rt=height(root.right);
        if(rt==-1){
            return -1;
        }
        if(Math.abs(rt-lt)>1){
            return -1;
        }
        return 1+Math.max(lt,rt);
    }

}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1: Balanced tree
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(solution.isBalanced(root1));  // Expected output: true

        // Test case 2: Unbalanced tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(2);
        root2.left.left.left = new TreeNode(3);
        root2.left.left.left.left = new TreeNode(3);
        root2.left.left.left.left.left = new TreeNode(3);
        System.out.println(solution.isBalanced(root2));  // Expected output: false

        // Test case 3: Empty tree
        TreeNode root3 = null;
        System.out.println(solution.isBalanced(root3));  // Expected output: true
    }
}
