import java.util.*;
/**
 * This class provides a solution to delete a node from a binary tree.
 * 
 * @author [Your Name]
 * @version 1.0
 */
/**
 * Approach: This solution uses a recursive approach to delete a node from a binary tree. It first checks if the root is null, then checks if the root's value matches the target value. If it does, it calls a helper function to handle the deletion. If not, it traverses the tree to find the target node and calls the helper function.
 * 
 * Time Complexity: O(h), where h is the height of the tree, because in the worst case, we might have to traverse from the root to a leaf node.
 * 
 * Space Complexity: O(h), because of the recursive call stack.
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
    public TreeNode deleteNode(TreeNode root, int x) {
        if(root==null){
            return root;
        }
        if(root.val==x){
            return helper(root,x);
        }
        TreeNode dummy= new TreeNode(-1);
        dummy.left=root;
        while(root!=null){
            if(root.val<x){
                if(root.right!=null && root.right.val==x){
                    root.right=helper(root.right,x);
                    break;
                }
                else root=root.right;
            }
            else if(root.val>x){
                if(root.left!=null && root.left.val==x){
                    root.left=helper(root.left,x);
                    break;
                }
                else root=root.left;
            }
        }
           return dummy.left;
    }
    public TreeNode helper(TreeNode root,int x){
        if(root.left==null){
            return root.right;
        }
        else if(root.right==null){
            return root.left;
        }
        else{
            TreeNode temp=root.right;
            TreeNode dum=root.left;
            while(temp.left!=null){
                temp=temp.left;
            }
            temp.left=dum;
            return root.right;
        }
    }
}

/**
 * Driver class to test the deleteNode method.
 */
public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test case 1:
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.left.left.left = new TreeNode(1);
        TreeNode result1 = solution.deleteNode(root1, 3);
        System.out.println("Test case 1 result: ");
        printTree(result1);
        
        // Test case 2:
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);
        TreeNode result2 = solution.deleteNode(root2, 2);
        System.out.println("Test case 2 result: ");
        printTree(result2);
        
        // Test case 3:
        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(3);
        root3.right = new TreeNode(6);
        root3.left.left = new TreeNode(2);
        root3.left.right = new TreeNode(4);
        root3.left.left.left = new TreeNode(1);
        TreeNode result3 = solution.deleteNode(root3, 5);
        System.out.println("Test case 3 result: ");
        printTree(result3);
    }
    
    public static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}