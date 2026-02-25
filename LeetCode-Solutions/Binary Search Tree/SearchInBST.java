import java.util.*;
/**
 * This class provides a solution to the problem of searching for a value in a Binary Search Tree.
 * 
 * @author [Your Name]
 * @version 1.0
 */
/**
 * Approach: This solution uses a recursive approach to traverse the Binary Search Tree. It starts at the root node and compares the target value with the current node's value. If the target value is less than the current node's value, it recursively searches the left subtree; otherwise, it searches the right subtree.
 * 
 * Time Complexity: O(h), where h is the height of the tree. In the worst-case scenario (an unbalanced tree), this becomes O(n), where n is the number of nodes in the tree. However, for a balanced tree, the time complexity is O(log n).
 * 
 * Space Complexity: O(h), due to the recursive call stack. In the worst-case scenario, this becomes O(n), but for a balanced tree, it is O(log n).
 */
public class Solution {
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
    public TreeNode searchBST(TreeNode root, int val) {
     if(root==null){
        return null;
     }
     if(root.val==val){
        return root;
     }
     if(root.val>val){
        return searchBST(root.left,val);
     }   
    else
       return searchBST(root.right,val);

    }
}
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test case 1: Searching for a value in a balanced tree
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        System.out.println("Test case 1 result: " + solution.searchBST(root1, 2).val);
        
        // Test case 2: Searching for a value in an unbalanced tree
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);
        System.out.println("Test case 2 result: " + solution.searchBST(root2, 3).val);
        
        // Test case 3: Searching for a non-existent value
        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(3);
        root3.right = new TreeNode(6);
        System.out.println("Test case 3 result: " + solution.searchBST(root3, 0));
    }
}