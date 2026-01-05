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
     * Approach: This solution uses both recursive and iterative methods to perform an inorder traversal of a binary tree.
     *          The recursive approach uses function calls to traverse the tree, while the iterative approach uses a stack to store nodes.
     * Time Complexity: O(n), where n is the number of nodes in the tree, since each node is visited once.
     * Space Complexity: O(n), where n is the number of nodes in the tree, due to the recursive call stack or the explicit stack used in the iterative approach.
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
        // traversal(root,path);
        iterative(root,path);
        return path;
    }
    public void recursive(TreeNode root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        recursive(root.left,path);
        path.add(root.val);
        recursive(root.right,path);
    }
    public void iterative(TreeNode root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
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
        // Test case 1: A simple binary tree
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        System.out.println("Inorder Traversal of Test Case 1: " + solution.inorderTraversal(root1));
        
        // Test case 2: A binary tree with only left children
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        System.out.println("Inorder Traversal of Test Case 2: " + solution.inorderTraversal(root2));
        
        // Test case 3: A binary tree with only right children
        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(2);
        root3.right.right = new TreeNode(3);
        root3.right.right.right = new TreeNode(4);
        System.out.println("Inorder Traversal of Test Case 3: " + solution.inorderTraversal(root3));
    }
}