
import java.util.*;

/**
 * This class provides a solution to the problem of flattening a binary tree into a linked list.
 * 
 * Approach: 
 * The solution uses a recursive approach to flatten the binary tree. It first flattens the left and right subtrees, 
 * then it rearranges the nodes to form a linked list. If the left subtree is not null, it sets the right child of the 
 * left tail to the right child of the root, and sets the right child of the root to the left child of the root. 
 * Finally, it sets the left child of the root to null.
 * 
 * Time Complexity: 
 * The time complexity of this solution is O(n), where n is the number of nodes in the binary tree. This is because 
 * each node is visited once during the recursive calls.
 * 
 * Space Complexity: 
 * The space complexity of this solution is O(h), where h is the height of the binary tree. This is because the 
 * maximum depth of the recursive call stack is equal to the height of the binary tree.
 */
public class FlattenBinaryTreeToLinkedList {
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
    public TreeNode flatten(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode leftTail = flatten(root.left);
        TreeNode rightTail = flatten(root.right);
        if (root.left != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;

        }

        if(rightTail!=null){
            return rightTail;
        }
        if(leftTail!=null){
            return leftTail;
        }
        
        return root;
    }

}

    public static class Driver {
        public static void main(String[] args) {
            Solution solution = new Solution();

            // Test case 1:
            //      1
            //     / 
            //    2   5
            //   /    
            //  3   4   6
            TreeNode root1 = new TreeNode(1);
            root1.left = new TreeNode(2);
            root1.right = new TreeNode(5);
            root1.left.left = new TreeNode(3);
            root1.left.right = new TreeNode(4);
            root1.right.right = new TreeNode(6);
            solution.flatten(root1);

            // Test case 2:
            //      1
            //       
            //        2
            //         
            //          3
            TreeNode root2 = new TreeNode(1);
            root2.right = new TreeNode(2);
            root2.right.right = new TreeNode(3);
            solution.flatten(root2);

            // Test case 3:
            //      1
            //     /
            //    2
            //   /
            //  3
            TreeNode root3 = new TreeNode(1);
            root3.left = new TreeNode(2);
            root3.left.left = new TreeNode(3);
            solution.flatten(root3);
        }
    }
}
