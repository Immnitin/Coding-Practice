import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * This class provides a solution for the Inorder Traversal of a Binary Tree.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class InorderTraversal {
    /**
     * Uses a Stack to perform Inorder Traversal of a Binary Tree.
     * The algorithm works by pushing nodes onto the stack as we traverse down the left subtree,
     * then popping nodes off the stack and visiting them as we traverse up the right subtree.
     * 
     * Time Complexity: O(N), where N is the number of nodes in the tree.
     * Space Complexity: O(N), where N is the number of nodes in the tree.
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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> path=new ArrayList<>();
        traversal(root,path);
        return path;
    }
    public void traversal(TreeNode root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        // traversal(root.left,path);
        //     path.add(root.val);
        // traversal(root.right,path);
        Stack<TreeNode> stk=new Stack<>();
        TreeNode node=root;
        while(true){
            if(node!=null){
                stk.push(node);
                node=node.left;
            }
            else{
                if(stk.isEmpty()){
                    break;
                }
                TreeNode temp=stk.pop();
                path.add(temp.val);
                node=temp.right;
            }
        }
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test case 1:
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        System.out.println(solution.inorderTraversal(root1));
        // Test case 2:
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);
        System.out.println(solution.inorderTraversal(root2));
        // Test case 3:
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        System.out.println(solution.inorderTraversal(root3));
    }
}