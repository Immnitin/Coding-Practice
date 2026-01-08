import java.util.*;
/**
 * Definition for checking if two binary trees are the same.
 * <p>
 * Approach: Uses a recursive depth-first search to compare the values of the nodes in the two trees.
 * If the values are different or if one tree has a node where the other does not, the function returns false.
 * Otherwise, it returns true.
 * <p>
 * Time Complexity: O(N), where N is the total number of nodes in the two trees.
 * Space Complexity: O(H), where H is the height of the deeper tree.
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        else if(p==null ||  q==null){return false;}
        if(p!=null && q!=null)
        {if(p.val!=q.val)
            return false;
        }
        boolean lt=isSameTree(p.left,q.left);
        boolean rt=isSameTree(p.right,q.right);
        return lt && rt;
    }
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test case 1: Two identical trees
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        System.out.println(solution.isSameTree(tree1, tree2)); // Expected output: true
        
        // Test case 2: Two different trees
        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);
        tree3.right = new TreeNode(3);
        TreeNode tree4 = new TreeNode(1);
        tree4.left = new TreeNode(2);
        tree4.right = new TreeNode(4);
        System.out.println(solution.isSameTree(tree3, tree4)); // Expected output: false
        
        // Test case 3: One tree is null
        TreeNode tree5 = new TreeNode(1);
        tree5.left = new TreeNode(2);
        tree5.right = new TreeNode(3);
        TreeNode tree6 = null;
        System.out.println(solution.isSameTree(tree5, tree6)); // Expected output: false
    }
}