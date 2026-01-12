import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution to the problem of finding the right side view of a binary tree.
 * 
 * @author [Your Name]
 */
public class Solution {
    /**
     * Returns a list of integers representing the right side view of a binary tree.
     * 
     * <p>Approach: Uses a pre-order traversal (root, right, left) to visit nodes in the tree.
     * If the current depth is equal to the size of the result list, it means we are at the rightmost node at this depth,
     * so we add the node's value to the result list.</p>
     * 
     * <p>Time Complexity: O(N), where N is the number of nodes in the tree, since we visit each node once.</p>
     * 
     * <p>Space Complexity: O(H), where H is the height of the tree, due to the recursive call stack.</p>
     * 
     * @param root the root of the binary tree
     * @return a list of integers representing the right side view of the binary tree
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
    public List<Integer> rightSideView(TreeNode root) {
    ArrayList<Integer> res=new ArrayList<>();
    preorder(root,0,res);
    return res;
    }
    public void preorder(TreeNode root, int depth, ArrayList<Integer> res){
        if(root==null){
            return ;
        }
        if(depth==res.size())
        {res.add(root.val);}
        preorder(root.right,depth+1,res);
        preorder(root.left,depth+1,res);
    }
}
}

/**
 * Driver class to test the solution.
 */
public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test case 1:
        //      1
        //       / \
        //      2   3
        //       / \n        //      4   5
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println(solution.rightSideView(root1)); // Expected output: [1, 3, 5]

        // Test case 2:
        //      1
        //       / \
        //      2   3
        //       / \
        //      4   5
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        System.out.println(solution.rightSideView(root2)); // Expected output: [1, 3, 5]

        // Test case 3:
        //      1
        //       / \
        //      2   3
        //         / \
        //        4   5
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.right.left = new TreeNode(4);
        root3.right.right = new TreeNode(5);
        System.out.println(solution.rightSideView(root3)); // Expected output: [1, 3, 5]
    }
}