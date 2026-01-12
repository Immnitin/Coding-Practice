import java.util.*;
/**
 * This class checks if a binary tree is symmetric.
 * 
 * @author [Your Name]
 * @version 1.0
 */
/**
 * Approach: This solution uses a recursive approach to check if a binary tree is symmetric.
 * It checks if the left subtree is a mirror reflection of the right subtree.
 * 
 * Time Complexity: O(N), where N is the number of nodes in the tree, since we visit each node once.
 * 
 * Space Complexity: O(H), where H is the height of the tree, due to the recursive call stack.
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return checkSymmetry(root.left,root.right);
    }
    public boolean checkSymmetry(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        if(root1.val!=root2.val){
        return false;
         }
          return checkSymmetry(root1.left,root2.right) && checkSymmetry(root1.right,root2.left);
    }
}

/**
 * Driver class to test the symmetric tree solution.
 */
public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1: Symmetric tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);
        System.out.println("Is tree symmetric? " + solution.isSymmetric(root1));
        
        // Test case 2: Asymmetric tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        System.out.println("Is tree symmetric? " + solution.isSymmetric(root2));
        
        // Test case 3: Empty tree
        TreeNode root3 = null;
        System.out.println("Is tree symmetric? " + solution.isSymmetric(root3));
    }
}