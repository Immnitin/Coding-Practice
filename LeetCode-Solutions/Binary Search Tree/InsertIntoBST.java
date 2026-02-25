import java.util.TreeMap;
import java.util.Map;
/**
 * This class provides a solution to insert a value into a Binary Search Tree.
 * 
 * @author [Your Name]
 * @version 1.0
 * @since [Date]
 *
 * Approach: This solution uses a recursive approach to insert a value into a Binary Search Tree.
 * It traverses the tree based on the comparison of the value to be inserted with the current node's value.
 * If the value is less than the current node's value, it moves to the left subtree; otherwise, it moves to the right subtree.
 * 
 * Time Complexity: O(h), where h is the height of the tree. In the worst case, the tree is skewed, and the time complexity becomes O(n), where n is the number of nodes in the tree.
 * 
 * Space Complexity: O(h), where h is the height of the tree. This is due to the recursive call stack.
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            TreeNode node=new TreeNode(val);
             root=node;
         }
         if(root.val>val){
             if(root.left!=null){
                 insertIntoBST(root.left,val);
             }
             
             else{TreeNode node=new TreeNode(val);
             root.left=node;
             return root;}
         }
         if(root.val<val){
             if(root.right!=null){
                 insertIntoBST(root.right,val);
             }
             else{
                 TreeNode node=new TreeNode(val);
                 root.right=node;
                 return root;
             }
         }
          return root;
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test case 1
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root = solution.insertIntoBST(root, 5);
        // Test case 2
        root = new TreeNode(40);
        root.left = new TreeNode(10);
        root.right = new TreeNode(50);
        root = solution.insertIntoBST(root, 20);
        // Test case 3
        root = null;
        root = solution.insertIntoBST(root, 10);
    }
}