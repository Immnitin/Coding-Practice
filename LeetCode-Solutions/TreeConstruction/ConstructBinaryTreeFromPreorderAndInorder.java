
import java.util.HashMap;

/**
 * This class provides a solution to construct a binary tree from its preorder and inorder traversals.
 * 
 * Approach: 
 * The solution uses a recursive approach to construct the binary tree. It first creates a HashMap to store the indices of the inorder traversal. 
 * Then, it recursively constructs the left and right subtrees by finding the root in the inorder traversal and dividing the preorder and inorder arrays accordingly.
 * 
 * Time Complexity: 
 * The time complexity of this solution is O(n), where n is the number of nodes in the tree. This is because each node is visited once during the construction of the HashMap and once during the recursive construction of the tree.
 * 
 * Space Complexity: 
 * The space complexity of this solution is O(n), where n is the number of nodes in the tree. This is because the HashMap stores the indices of all nodes in the inorder traversal, and the recursive call stack can go up to a depth of n in the worst case.
 */
public class ConstructBinaryTreeFromPreorderAndInorder {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }       
        return bt(preorder,inorder,map,0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode bt(int[] preorder, int[] inorder, HashMap<Integer,Integer> map,int pst,int ped,int ist, int ied){
        if(pst>ped || ist>ied){
            return null;
        }
        TreeNode root=new TreeNode(preorder[pst]);

        int irt=map.get(root.val);
        int nl=irt-ist;

        root.left=bt(preorder,inorder,map,pst+1,pst+nl,ist,irt-1);
        root.right=bt(preorder,inorder,map,pst+nl+1,ped,irt+1,ied);
        
        return root;
    }
}

    public static class Driver {
        public static void main(String[] args) {
            Solution solution = new Solution();
            
            // Test case 1:
            int[] preorder1 = {3, 9, 20, 15, 7};
            int[] inorder1 = {9, 3, 15, 20, 7};
            TreeNode root1 = solution.buildTree(preorder1, inorder1);
            System.out.println("Root of the first tree: " + root1.val);

            // Test case 2:
            int[] preorder2 = {1, 2, 4, 5, 3, 6, 7};
            int[] inorder2 = {4, 2, 5, 1, 6, 3, 7};
            TreeNode root2 = solution.buildTree(preorder2, inorder2);
            System.out.println("Root of the second tree: " + root2.val);

            // Test case 3:
            int[] preorder3 = {1};
            int[] inorder3 = {1};
            TreeNode root3 = solution.buildTree(preorder3, inorder3);
            System.out.println("Root of the third tree: " + root3.val);
        }
    }
}
