
import java.util.HashMap;

/**
 * This class provides a solution to construct a binary tree from given inorder and postorder traversals.
 * 
 * Approach: 
 * Uses a recursive approach to construct the binary tree. It first creates a HashMap to store the indices of the inorder traversal. 
 * Then it recursively constructs the left and right subtrees by finding the root node in the inorder traversal and dividing the postorder traversal accordingly.
 * 
 * Time Complexity: 
 * O(n), where n is the number of nodes in the tree, because each node is visited once during the construction process.
 * 
 * Space Complexity: 
 * O(n), where n is the number of nodes in the tree, because in the worst case, the recursion call stack can go up to n levels deep, and the HashMap stores n nodes.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return bt(inorder,postorder,map,0,postorder.length-1,0,inorder.length-1);

    }
    public TreeNode bt(int[] inorder,int[] postorder,HashMap<Integer,Integer> map, int pst,int ped, int ist, int ied){
    if(pst>ped || ist>ied){
        return null;
    }
    TreeNode root=new TreeNode(postorder[ped]);
    int irt=map.get(root.val);
    int nl=irt-ist;

    root.left=bt(inorder,postorder,map, pst, pst+nl-1,ist ,irt-1);
    root.right=bt(inorder,postorder,map, pst+nl, ped-1, irt+1, ied);
    return root;
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] inorder1 = {4, 2, 5, 1, 3};
        int[] postorder1 = {4, 5, 2, 3, 1};
        TreeNode root1 = solution.buildTree(inorder1, postorder1);
        
        // Test case 2
        int[] inorder2 = {2, 1, 3};
        int[] postorder2 = {2, 3, 1};
        TreeNode root2 = solution.buildTree(inorder2, postorder2);
        
        // Test case 3
        int[] inorder3 = {1, 2, 3, 4, 5};
        int[] postorder3 = {1, 2, 3, 4, 5};
        TreeNode root3 = solution.buildTree(inorder3, postorder3);
    }
}
