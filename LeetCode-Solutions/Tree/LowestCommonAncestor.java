
import java.util.*;

/**
 * This class provides a solution to find the lowest common ancestor of two nodes in a binary tree.
 * 
 * Approach: 
 * Uses a recursive approach to traverse the binary tree. If the current node is null or matches either of the target nodes, 
 * it returns the current node. Otherwise, it recursively searches for the target nodes in the left and right subtrees. 
 * If both target nodes are found in different subtrees, the current node is the lowest common ancestor. 
 * If both target nodes are found in the same subtree, the lowest common ancestor is in that subtree.
 * 
 * Time Complexity: 
 * O(N), where N is the number of nodes in the binary tree, since each node is visited at most once.
 * 
 * Space Complexity: 
 * O(H), where H is the height of the binary tree, due to the recursive call stack. In the worst case, the tree is skewed, 
 * and the space complexity becomes O(N).
 */
public class LowestCommonAncestorSolution {
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
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode lt=lowestCommonAncestor(root.left,p,q);
        TreeNode rt=lowestCommonAncestor(root.right,p,q);
        if(lt==null){
            return rt;
        }
        else if(rt==null){
            return lt;
        }
        else 
        return root;
    }
}

    public static class Driver {
        public static void main(String[] args) {
            // Test case 1:
            TreeNode root1 = new TreeNode(3);
            root1.left = new TreeNode(5);
            root1.right = new TreeNode(1);
            root1.left.left = new TreeNode(6);
            root1.left.right = new TreeNode(2);
            root1.right.left = new TreeNode(0);
            root1.right.right = new TreeNode(8);
            root1.left.right.left = new TreeNode(7);
            root1.left.right.right = new TreeNode(4);
            TreeNode p1 = root1.left;
            TreeNode q1 = root1.right;
            LowestCommonAncestorSolution solution = new LowestCommonAncestorSolution();
            TreeNode result1 = solution.lowestCommonAncestor(root1, p1, q1);
            System.out.println("Test case 1 result: " + result1.val);

            // Test case 2:
            TreeNode root2 = new TreeNode(1);
            root2.left = new TreeNode(2);
            TreeNode p2 = root2;
            TreeNode q2 = root2.left;
            TreeNode result2 = solution.lowestCommonAncestor(root2, p2, q2);
            System.out.println("Test case 2 result: " + result2.val);

            // Test case 3:
            TreeNode root3 = new TreeNode(1);
            root3.right = new TreeNode(2);
            TreeNode p3 = root3;
            TreeNode q3 = root3.right;
            TreeNode result3 = solution.lowestCommonAncestor(root3, p3, q3);
            System.out.println("Test case 3 result: " + result3.val);
        }
    }
}