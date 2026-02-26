import java.util.Stack;

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
/**
 * Approach: Uses a Stack to perform an in-order traversal of the binary search tree.
 * The algorithm starts by pushing all the left nodes from the root onto the stack.
 * Then, it pops the top node from the stack, returns its value, and pushes all the left nodes from its right child onto the stack.
 * Time Complexity: O(n), where n is the number of nodes in the binary search tree.
 * Space Complexity: O(n), where n is the number of nodes in the binary search tree.
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
class BSTIterator {
    public Stack<TreeNode> stk=new Stack<>();
    public BSTIterator(TreeNode root) {
        pushAllLeft(root);
    }
    
    public int next() {
        TreeNode curr=stk.pop();
        if(curr.right!=null){
            pushAllLeft(curr.right);
        }
        return curr.val;
    }
    
    public boolean hasNext() {
        if(!stk.isEmpty()){
            return true;
        }
        else return false;
    }

    public void pushAllLeft(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode temp=root;
        while(temp!=null){
            stk.push(temp);
            temp=temp.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

public class Driver {
    public static void main(String[] args) {
        // Test case 1
        TreeNode root1 = new TreeNode(7);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(15);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(20);
        BSTIterator iterator1 = new BSTIterator(root1);
        System.out.println("Test case 1:");
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }
        System.out.println();

        // Test case 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(9);
        BSTIterator iterator2 = new BSTIterator(root2);
        System.out.println("Test case 2:");
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + " ");
        }
        System.out.println();

        // Test case 3
        TreeNode root3 = new TreeNode(10);
        root3.left = new TreeNode(5);
        root3.right = new TreeNode(15);
        root3.left.left = new TreeNode(2);
        root3.left.right = new TreeNode(7);
        root3.right.right = new TreeNode(20);
        BSTIterator iterator3 = new BSTIterator(root3);
        System.out.println("Test case 3:");
        while (iterator3.hasNext()) {
            System.out.print(iterator3.next() + " ");
        }
    }
}