import java.util.Arrays;
/**
 * This class constructs a binary search tree from a given preorder traversal.
 * 
 * @author [Your Name]
 * @version 1.0
 */
/**
 * Approach: This solution uses a recursive approach to construct the binary search tree from the preorder traversal.
 * It maintains an index to track the current node in the preorder array and a bound to ensure that the left subtree of a node contains only values less than the node's value.
 * 
 * Time Complexity: O(n), where n is the number of nodes in the binary search tree, since each node is visited once.
 * Space Complexity: O(n), where n is the number of nodes in the binary search tree, due to the recursive call stack and the space required to store the tree.
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
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=construct(preorder, Integer.MAX_VALUE);
        return root;
    }
    public TreeNode construct(int[] preorder, int bound){
        if(i>= preorder.length || preorder[i]>bound){
            return null ; 
        }
        TreeNode root=new TreeNode(preorder[i]);
        System.out.println(root.val+" "+i);
        root.left=construct(preorder,preorder[i++]);
        root.right=construct(preorder,bound);
        return root;
    }
}

/**
 * Driver class to test the BSTFromPreorder class.
 */
public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder1 = {8, 5, 1, 7, 10, 12};
        int[] preorder2 = {4, 2};
        int[] preorder3 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 1:");
        printTree(solution.bstFromPreorder(preorder1));
        System.out.println("Test Case 2:");
        printTree(solution.bstFromPreorder(preorder2));
        System.out.println("Test Case 3:");
        printTree(solution.bstFromPreorder(preorder3));
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}