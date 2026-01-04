import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * This class provides a solution for the preorder traversal of a binary tree.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class Solution {
    /**
     * Uses a stack-based iterative approach to perform a preorder traversal of the binary tree.
     * The algorithm starts by pushing the root node onto the stack, then enters a loop where it pops a node from the stack, adds its value to the result list, and pushes its right and left children onto the stack.
     * 
     * Time Complexity: O(N), where N is the number of nodes in the binary tree, since each node is visited once.
     * Space Complexity: O(N), where N is the number of nodes in the binary tree, since in the worst case, the stack can contain all nodes at the last level of the tree.
     * 
     * @param root The root of the binary tree.
     * @return A list of node values in preorder traversal order.
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
    helper(root,list);
    return list;
    }
    public void helper(TreeNode root, ArrayList<Integer> list){
        if(root==null){
            return;
        }
        // list.add(root.val);
        // helper(root.left,list);
        // helper(root.right,list);
        Stack<TreeNode> stk=new Stack<>();
        stk.push(root);
        while(!stk.isEmpty()){
            TreeNode num=stk.pop();
            list.add(num.val);
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
        // Test case 1: Empty tree
        System.out.println(solution.preorderTraversal(null));
        // Test case 2: Tree with one node
        TreeNode root1 = new TreeNode(1);
        System.out.println(solution.preorderTraversal(root1));
        // Test case 3: Tree with multiple nodes
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        System.out.println(solution.preorderTraversal(root2));
    }
}