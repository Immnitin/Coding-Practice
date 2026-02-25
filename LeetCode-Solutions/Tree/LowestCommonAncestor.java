
import java.util.*;

/**
 * This class provides a solution to find the lowest common ancestor of two nodes in a binary tree.
 * 
 * Approach: 
 * Uses a recursive approach to traverse the binary tree. The function checks if the current node is null or if its value matches either of the target nodes. 
 * If the current node's value is greater than both target nodes, it recursively calls the function on the left child. 
 * If the current node's value is less than both target nodes, it recursively calls the function on the right child. 
 * Otherwise, it returns the current node as the lowest common ancestor.
 * 
 * Time Complexity: 
 * O(h), where h is the height of the binary tree. In the worst case, the tree is skewed and the time complexity becomes O(n), where n is the number of nodes in the tree.
 * 
 * Space Complexity: 
 * O(h), where h is the height of the binary tree. This is due to the recursive call stack.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root.val==p.val || root.val==q.val){
            return root;
        }
        else if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        else return root;
        
    }
}

class Driver {
    public static void main(String[] args) {
        // Test case 1:
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        TreeNode p = root.left.left; // Node with value 0
        TreeNode q = root.right.right; // Node with value 9
        System.out.println("Lowest common ancestor of nodes with values 0 and 9 is: " + new Solution().lowestCommonAncestor(root, p, q).val);

        // Test case 2:
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        p = root; // Node with value 2
        q = root.left; // Node with value 1
        System.out.println("Lowest common ancestor of nodes with values 2 and 1 is: " + new Solution().lowestCommonAncestor(root, p, q).val);

        // Test case 3:
        root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        p = root.left; // Node with value 0
        q = root.right; // Node with value 2
        System.out.println("Lowest common ancestor of nodes with values 0 and 2 is: " + new Solution().lowestCommonAncestor(root, p, q).val);
    }
}
