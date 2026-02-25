import java.util.Arrays;

/**
 * This class provides a solution to find the kth smallest element in a binary search tree.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class KthSmallestElement {
    /**
     * Approach: This solution uses an in-order traversal of the binary search tree to find the kth smallest element.
     * The in-order traversal visits the left subtree, the current node, and then the right subtree. This ensures that the nodes are visited in ascending order.
     * 
     * Time Complexity: O(n), where n is the number of nodes in the binary search tree, because in the worst case, we need to visit all nodes.
     * 
     * Space Complexity: O(h), where h is the height of the binary search tree, because of the recursive call stack. In the worst case, the tree is skewed and h = n.
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
    public int kthSmallest(TreeNode root, int k) {
        int[] arr=new int[1];
        traversal(root, k,arr);
        return arr[0];
    }
    public void traversal(TreeNode root,int k, int[] arr){
        if(root==null){
            return ;
        }
        traversal(root.left,k,arr);
        i++;
        if(i==k){
            arr[0]=root.val;
            return;
        }
        traversal(root.right,k,arr);
    }
}       

    public static class Driver {
        public static void main(String[] args) {
            Solution solution = new Solution();
            // Test case 1:
            TreeNode root1 = new TreeNode(3);
            root1.left = new TreeNode(1);
            root1.right = new TreeNode(4);
            root1.left.right = new TreeNode(2);
            System.out.println("Kth smallest element in the first test case: " + solution.kthSmallest(root1, 1));

            // Test case 2:
            TreeNode root2 = new TreeNode(5);
            root2.left = new TreeNode(3);
            root2.right = new TreeNode(6);
            root2.left.left = new TreeNode(2);
            root2.left.right = new TreeNode(4);
            root2.left.left.left = new TreeNode(1);
            System.out.println("Kth smallest element in the second test case: " + solution.kthSmallest(root2, 3));
        }
    }
}