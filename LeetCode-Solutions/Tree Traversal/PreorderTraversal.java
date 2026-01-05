import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * This class provides a solution for the preorder traversal of a binary tree.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class PreorderTraversal {
    /**
     * This method performs a preorder traversal of a binary tree and returns the result as a list.
     * 
     * Approach: The solution uses two approaches: recursive and iterative. The recursive approach uses function calls to traverse the tree, while the iterative approach uses a stack to store nodes to be visited.
     * 
     * Time Complexity: O(n), where n is the number of nodes in the tree, since each node is visited once.
     * 
     * Space Complexity: O(n), where n is the number of nodes in the tree, since in the worst case, the recursive call stack or the stack used in the iterative approach can grow up to the height of the tree, which is n for an unbalanced tree.
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
    public List<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> list=new ArrayList<>();
    // recursive(root,list);
    iterative(root,list);
    return list;
    }
    public void recursive(TreeNode root, ArrayList<Integer> list){
        if(root==null){
            return;
        }
        list.add(root.val);
        recursive(root.left,list);
        recursive(root.right,list);  
    }
    public void iterative(TreeNode root,List<Integer> path){
         if(root==null){
            return;
        }
         Stack<TreeNode> stk=new Stack<>();
        stk.push(root);
        while(!stk.isEmpty()){
            TreeNode num=stk.pop();
            path.add(num.val);
            if(num.right!=null){
                stk.push(num.right);
            }
            if(num.left!=null){
                stk.push(num.left);
            }
        }
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test case 1: A simple binary tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println("Preorder traversal of the first tree: " + solution.preorderTraversal(root1));
        
        // Test case 2: An empty tree
        TreeNode root2 = null;
        System.out.println("Preorder traversal of the second tree: " + solution.preorderTraversal(root2));
        
        // Test case 3: A tree with only one node
        TreeNode root3 = new TreeNode(1);
        System.out.println("Preorder traversal of the third tree: " + solution.preorderTraversal(root3));
    }
}