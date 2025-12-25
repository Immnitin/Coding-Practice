import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution for postorder traversal of a binary tree.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class PostorderTraversal {
    /**
     * Uses a recursive approach to perform postorder traversal of a binary tree.
     * The postorder traversal visits the left subtree, then the right subtree, and finally the root node.
     * 
     * Approach: Recursive postorder traversal.
     * Time Complexity: O(N), where N is the number of nodes in the binary tree, since we visit each node once.
     * Space Complexity: O(H), where H is the height of the binary tree, due to the recursive call stack.
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        traversal(root,res);
        return res;
    }
    public void traversal(TreeNode root,List<Integer> res){
        if(root==null){
            return;
        }
        traversal(root.left,res);
        traversal(root.right,res);
        res.add(root.val);
    }
}

    public static class Driver {
        public static void main(String[] args) {
            Solution solution = new Solution();
            // Test case 1: A simple binary tree
            TreeNode root1 = new TreeNode(1);
            root1.left = new TreeNode(2);
            root1.right = new TreeNode(3);
            System.out.println("Postorder traversal of test case 1: " + solution.postorderTraversal(root1));

            // Test case 2: A binary tree with multiple levels
            TreeNode root2 = new TreeNode(1);
            root2.left = new TreeNode(2);
            root2.right = new TreeNode(3);
            root2.left.left = new TreeNode(4);
            root2.left.right = new TreeNode(5);
            System.out.println("Postorder traversal of test case 2: " + solution.postorderTraversal(root2));

            // Test case 3: An empty binary tree
            TreeNode root3 = null;
            System.out.println("Postorder traversal of test case 3: " + solution.postorderTraversal(root3));
        }
    }
}