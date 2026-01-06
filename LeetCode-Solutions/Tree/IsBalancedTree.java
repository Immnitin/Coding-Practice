import java.util.TreeMap;
import java.util.Map;
/**
 * Approach: This solution uses a recursive approach to calculate the height of each subtree and check if the tree is balanced.
 * Time Complexity: O(N), where N is the number of nodes in the tree, since we visit each node once.
 * Space Complexity: O(H), where H is the height of the tree, due to the recursive call stack.
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
    public boolean isBalanced(TreeNode root) {
      if(height(root)==-1){
      return false;
      }
      return true;
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lt=height(root.left);
        if(lt==-1){
            return -1;
        }
        int rt=height(root.right);
        if(rt==-1){
            return -1;
        }
        if(Math.abs(rt-lt)>1){
            return -1;
        }
        return 1+Math.max(lt,rt);
    }

}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test case 1: Balanced tree
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("Is tree balanced? " + solution.isBalanced(root1));
        
        // Test case 2: Unbalanced tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);
        System.out.println("Is tree balanced? " + solution.isBalanced(root2));
        
        // Test case 3: Empty tree
        TreeNode root3 = null;
        System.out.println("Is tree balanced? " + solution.isBalanced(root3));
    }
}