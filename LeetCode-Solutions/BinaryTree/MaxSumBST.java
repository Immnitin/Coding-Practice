import java.util.*;

/**
 * This class provides a solution to find the maximum sum of a Binary Search Tree (BST) in a given binary tree.
 * 
 * Approach: 
 * The solution uses a postorder traversal to check if each subtree is a valid BST. 
 * It maintains a nodedata object for each node, which stores whether the subtree rooted at the node is a valid BST, 
 * the minimum and maximum values in the subtree, and the sum of all node values in the subtree.
 * 
 * Time Complexity: 
 * The time complexity is O(N), where N is the number of nodes in the binary tree, since we visit each node once.
 * 
 * Space Complexity: 
 * The space complexity is O(H), where H is the height of the binary tree, due to the recursive call stack.
 * In the worst case, the tree is skewed and the space complexity becomes O(N).
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
    class nodedata{
        boolean isValid;
        int min;
        int max;
        int sum;
        public nodedata(boolean isValid, int min, int max, int sum){
            this.isValid=isValid;
            this.min=min;
            this.max=max;
            this.sum=sum;
        }
    }

    public int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        postorder(root);
        return maxSum;
    }

    public nodedata postorder(TreeNode root) {
        if (root == null) {
            return new nodedata(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        nodedata left = postorder(root.left);
        nodedata right = postorder(root.right);
        int summ = 0;
        if (left.isValid && right.isValid && root.val > left.max && root.val < right.min) {
            summ = root.val + left.sum + right.sum;
            maxSum = Math.max(summ, maxSum);
            return new nodedata(true, Math.min(root.val, left.min), Math.max(root.val, right.max), summ);
        }
        return new nodedata(false, Math.min(root.val, left.min), Math.max(root.val, right.max), summ );
    }

}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1:
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(5);
        System.out.println("Max sum of BST in tree 1: " + solution.maxSumBST(root1));
        
        // Test case 2:
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(8);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(0);
        root2.left.right = new TreeNode(1);
        root2.right.right = new TreeNode(6);
        System.out.println("Max sum of BST in tree 2: " + solution.maxSumBST(root2));
        
        // Test case 3:
        TreeNode root3 = new TreeNode(10);
        root3.left = new TreeNode(5);
        root3.right = new TreeNode(15);
        root3.right.right = new TreeNode(20);
        System.out.println("Max sum of BST in tree 3: " + solution.maxSumBST(root3));
    }
}
