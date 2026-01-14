import java.util.ArrayList;
import java.util.List;
/**
 * This class provides a solution to count the number of nodes in a binary tree.
 * 
 * @author [Your Name]
 * @version 1.0
 */
/**
 * Approach: Uses a recursive preorder traversal to count the number of nodes in the binary tree.
 * Time Complexity: O(N), where N is the number of nodes in the binary tree, since we visit each node once.
 * Space Complexity: O(H), where H is the height of the binary tree, due to the recursive call stack. In the worst case, the tree is skewed and H = N.
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
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int[] cnt=new int[1];
        preorder(root,cnt);
        return cnt[0];
    }
    public void preorder(TreeNode root,int[] cnt){
        if(root==null){
            return; 
        }
        cnt[0]++;
        preorder(root.left,cnt);
        preorder(root.right,cnt);
    }
}

/**
 * Driver class to test the solution.
 */
class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test case 1: Empty tree
        TreeNode root1 = null;
        System.out.println("Test case 1: Expected output = 0, Actual output = " + solution.countNodes(root1));
        
        // Test case 2: Tree with one node
        TreeNode root2 = new TreeNode(1);
        System.out.println("Test case 2: Expected output = 1, Actual output = " + solution.countNodes(root2));
        
        // Test case 3: Tree with multiple nodes
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.left.left = new TreeNode(4);
        root3.left.right = new TreeNode(5);
        System.out.println("Test case 3: Expected output = 5, Actual output = " + solution.countNodes(root3));
    }
}