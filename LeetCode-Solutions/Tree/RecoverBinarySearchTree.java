import java.util.*;
/**
 * This class provides a solution to recover a binary search tree from two swapped nodes.
 * 
 * @author [Your Name]
 * @version 1.0
 */
/**
 * Approach: Uses an in-order traversal to identify the two nodes that are out of order in the binary search tree.
 * Time Complexity: O(n), where n is the number of nodes in the tree, since we perform a single in-order traversal.
 * Space Complexity: O(h), where h is the height of the tree, due to the recursive call stack.
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
    TreeNode prev=null;
    TreeNode first=null;
    TreeNode middle=null;
    TreeNode last=null;
    public void recoverTree(TreeNode root) {
        if(root==null){
            return;
        }
        inorder(root);
        if(last==null){
            int temp=first.val;
            first.val=middle.val;
            middle.val=temp;
        }
        else{
            int temp=last.val;
            last.val=first.val;
            first.val=temp;
        }
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(prev!=null && prev.val>root.val){
            if(first==null && middle==null){
                first=prev;
                middle=root;
            }
            else last=root;
        }
        prev=root;
        inorder(root.right);
    }
}

/**
 * Driver class to test the recoverTree method.
 */
public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test case 1: A simple binary search tree with two swapped nodes.
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        solution.recoverTree(root1);
        // Test case 2: A more complex binary search tree with two swapped nodes.
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.left.right = new TreeNode(2);
        solution.recoverTree(root2);
        // Test case 3: An empty binary search tree.
        TreeNode root3 = null;
        solution.recoverTree(root3);
    }
}