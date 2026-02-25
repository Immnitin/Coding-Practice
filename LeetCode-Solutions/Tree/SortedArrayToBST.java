import java.util.Arrays;

/**
 * This class contains a method to convert a sorted array into a balanced binary search tree.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class SortedArrayToBST {
    /**
     * Approach: This solution uses a recursive approach to construct the binary search tree.
     * It selects the middle element of the array as the root and recursively constructs the left and right subtrees.
     * 
     * Time Complexity: O(n), where n is the number of elements in the array, since we visit each element once.
     * 
     * Space Complexity: O(log n), where n is the number of elements in the array, due to the recursive call stack.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(0,nums.length,nums);
    }
    public TreeNode construct(int st, int ed, int[] nums){
        if(st>ed ){
            return null;
        }
        int mid=(st+ed)/2;
        TreeNode root=null;
        if(mid<nums.length){
        root=new TreeNode(nums[mid]);
        root.left=construct(st,mid-1,nums);
        root.right=construct(mid+1,ed,nums);}
        return root;
    }
}

    public static class Driver {
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] nums1 = {-10, -3, 0, 5, 9};
            TreeNode result1 = solution.sortedArrayToBST(nums1);
            System.out.println("Result 1:");
            printTree(result1);

            int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
            TreeNode result2 = solution.sortedArrayToBST(nums2);
            System.out.println("Result 2:");
            printTree(result2);

            int[] nums3 = {};
            TreeNode result3 = solution.sortedArrayToBST(nums3);
            System.out.println("Result 3:");
            printTree(result3);
        }

        public static void printTree(TreeNode root) {
            if (root == null) return;
            System.out.print(root.val + " ");
            printTree(root.left);
            printTree(root.right);
        }
    }
}