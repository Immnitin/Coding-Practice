
import java.util.HashSet;

/**
 * This class checks whether a given binary tree is a valid binary search tree (BST).
 * 
 * Approach: 
 * This solution uses a recursive approach to validate whether a binary tree is a valid BST. 
 * It checks each node to ensure that all elements in its left subtree are less than the node, 
 * and all elements in its right subtree are greater than the node. 
 * This is achieved by maintaining a valid range for each node, which is updated as the tree is traversed.
 * 
 * Time Complexity: 
 * The time complexity of this solution is O(n), where n is the number of nodes in the tree, 
 * since each node is visited once.
 * 
 * Space Complexity: 
 * The space complexity of this solution is O(h), where h is the height of the tree, 
 * due to the recursive call stack. In the worst case, the tree is skewed and h = n.
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
    HashSet<Integer> set=new HashSet<>();
    public boolean isValidBST(TreeNode root) {
        if(root.left==null && root.right==null){
            return true;
        }
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean validate(TreeNode root, long min , long max){
         if(root==null){
            return true;
        }
        // if(root!=null && !set.contains(root.val)){
        //         set.add(root.val);
        //         System.out.println(set);
        //     }
        boolean lt=false;
        boolean rt=false;
        if(min<root.val && root.val<max){
            if(root.left!=null && root.val==root.left.val ){
                lt=false;
            }
            else{ 
             lt=validate(root.left,min,root.val);
            }
            
            if(root.right!=null && root.val==root.right.val){
                rt=false;
            }
            else{
            rt=validate(root.right,root.val,max);
            }
        }
        return lt && rt;
    }
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1: A valid BST
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("Is valid BST: " + solution.isValidBST(root1));  // Expected output: true

        // Test case 2: An invalid BST
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Is valid BST: " + solution.isValidBST(root2));  // Expected output: false

        // Test case 3: An empty tree
        TreeNode root3 = null;
        System.out.println("Is valid BST: " + solution.isValidBST(root3));  // Expected output: true
    }
}
