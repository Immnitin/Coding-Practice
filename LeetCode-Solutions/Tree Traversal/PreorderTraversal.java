import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution for the preorder traversal of a binary tree.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class PreorderTraversal {
    /**
     * Uses a recursive helper function to perform the preorder traversal of a binary tree.
     * The approach involves visiting the current node, then recursively traversing the left subtree, and finally the right subtree.
     * 
     * Time Complexity: O(N), where N is the number of nodes in the binary tree, since each node is visited once.
     * Space Complexity: O(N), due to the recursive call stack and the space required to store the result.
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
    public List<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> list=new ArrayList<>();
    helper(root,list);
    return list;
    }
    public void helper(TreeNode root, ArrayList<Integer> list){
        if(root==null){
            return;
        }
        list.add(root.val);
        helper(root.left,list);
        helper(root.right,list);
    }
}

    public static class Driver {
        public static void main(String[] args) {
            Solution solution = new Solution();
            // Test case 1: Empty tree
            TreeNode root1 = null;
            System.out.println("Test case 1: " + solution.preorderTraversal(root1));
            // Test case 2: Single node tree
            TreeNode root2 = new TreeNode(1);
            System.out.println("Test case 2: " + solution.preorderTraversal(root2));
            // Test case 3: Balanced binary tree
            TreeNode root3 = new TreeNode(1);
            root3.left = new TreeNode(2);
            root3.right = new TreeNode(3);
            root3.left.left = new TreeNode(4);
            root3.left.right = new TreeNode(5);
            root3.right.left = new TreeNode(6);
            root3.right.right = new TreeNode(7);
            System.out.println("Test case 3: " + solution.preorderTraversal(root3));
        }
    }
}