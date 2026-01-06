
import java.util.*;

/**
 * This class provides a solution for postorder traversal of a binary tree.
 * 
 * Approach: 
 * The solution uses three approaches: 
 * 1. Recursive approach: Uses recursive calls to traverse the tree.
 * 2. Two-stack approach: Uses two stacks to store nodes and their children.
 * 3. One-stack approach: Uses a single stack to store nodes and their children.
 * 
 * Time Complexity: 
 * The time complexity for all approaches is O(n), where n is the number of nodes in the tree.
 * 
 * Space Complexity: 
 * The space complexity for the recursive approach is O(h), where h is the height of the tree.
 * The space complexity for the two-stack approach is O(n), where n is the number of nodes in the tree.
 * The space complexity for the one-stack approach is O(n), where n is the number of nodes in the tree.
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // recursive(root,res);
        // using2Stack(root, res);
        using1Stack(root,res);
        return res;
    }

    public void recursive(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        recursive(root.left, res);
        recursive(root.right, res);
        res.add(root.val);
    }

    public void using2Stack(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stk1 = new Stack<>();
        Stack<TreeNode> stk2 = new Stack<>();
        TreeNode node = root;
        stk1.push(node);
        while (!stk1.isEmpty()) {
            TreeNode temp = stk1.pop();
            if (temp.left != null) {
                stk1.push(temp.left);
            }
            if (temp.right != null) {
                stk1.push(temp.right);
            }
            stk2.push(temp);
        }
        while (!stk2.isEmpty()) {
            res.add(stk2.pop().val);
        }
    }

    public void using1Stack(TreeNode root,List<Integer> res){
        Stack<TreeNode> stk= new Stack<>();
        TreeNode node=root;
        while(node!=null || !stk.isEmpty()){
            if(node!=null){
                stk.push(node);
                node=node.left;
            }
            else{
                TreeNode temp=stk.peek().right;
                if(temp==null){
                    temp=stk.peek();
                    stk.pop();
                    res.add(temp.val);
                    while(!stk.isEmpty() && temp==stk.peek().right){
                        temp=stk.peek();
                        stk.pop();
                        res.add(temp.val);
                    }
                }
                else 
                    node=temp;
            }
        }
    }
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1:
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println("Postorder Traversal of Tree 1: " + solution.postorderTraversal(root1));
        
        // Test case 2:
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.left = new TreeNode(3);
        System.out.println("Postorder Traversal of Tree 2: " + solution.postorderTraversal(root2));
        
        // Test case 3:
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.left.left = new TreeNode(4);
        root3.left.right = new TreeNode(5);
        root3.right.left = new TreeNode(6);
        root3.right.right = new TreeNode(7);
        System.out.println("Postorder Traversal of Tree 3: " + solution.postorderTraversal(root3));
    }
}
