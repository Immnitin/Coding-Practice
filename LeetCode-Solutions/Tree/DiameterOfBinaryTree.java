
import java.util.*;

/**
 * This class calculates the diameter of a binary tree.
 * 
 * Approach: 
 * The algorithm uses a recursive depth-first search (DFS) approach to calculate the height of each subtree and 
 * update the maximum diameter found so far. The height of a tree is the number of edges on the longest path 
 * from the root to a leaf. The diameter of a tree is the longest path between any two nodes in a tree. 
 * This path may or may not pass through the root.
 * 
 * Time Complexity: 
 * The time complexity of this solution is O(N), where N is the number of nodes in the tree. This is because 
 * each node is visited once during the DFS traversal.
 * 
 * Space Complexity: 
 * The space complexity of this solution is O(H), where H is the height of the tree. This is because the 
 * maximum depth of the recursive call stack is equal to the height of the tree.
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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max=new int[1];
        height(root,max);
        return max[0];
    }
    public int height(TreeNode root, int[] max){
        if(root==null){
        return 0;
    }
    int lt=height(root.left,max);
    int rt=height(root.right,max);
    max[0]=Math.max(max[0],lt+rt);
    return 1+Math.max(lt,rt);
    }
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1:
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println("Diameter of binary tree 1: " + solution.diameterOfBinaryTree(root1));
        
        // Test case 2:
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        System.out.println("Diameter of binary tree 2: " + solution.diameterOfBinaryTree(root2));
        
        // Test case 3:
        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(2);
        root3.right.right = new TreeNode(3);
        root3.right.right.right = new TreeNode(4);
        System.out.println("Diameter of binary tree 3: " + solution.diameterOfBinaryTree(root3));
    }
}
