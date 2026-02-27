
import java.util.Stack;

/**
 * This class provides a solution to find a target sum in a binary tree.
 * 
 * Approach: Uses two stacks to perform an in-order traversal and a reverse in-order traversal of the binary tree.
 * The algorithm maintains two pointers, one at the start of the in-order traversal and one at the end of the reverse in-order traversal.
 * It then moves the pointers based on the sum of the values at the current positions, until it finds a pair that sums up to the target or until one of the pointers reaches the end.
 * 
 * Time Complexity: O(n), where n is the number of nodes in the binary tree, since each node is visited at most twice.
 * Space Complexity: O(n), where n is the number of nodes in the binary tree, since in the worst case, the stacks can contain all nodes.
 * 
 * @author [Your Name]
 */
public class Solution {
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
    public boolean findTarget(TreeNode root, int k) {
    Stack<TreeNode> nxtstk=new Stack<TreeNode>();
    Stack<TreeNode> bfrstk=new Stack<TreeNode>();
    pushAllLeft(root,nxtstk);
    pushAllRight(root,bfrstk);
    int nxt=next(nxtstk);
    int bfr=before(bfrstk);
    while(!nxtstk.isEmpty() && !bfrstk.isEmpty()){
        int sum=nxt+bfr;
        // System.out.println("nxt "+nxt+" bfr "+bfr+" sum "+sum);
        if(nxt==bfr){
            return false;
        }
        if(sum==k){
            return true;
        }
        if(sum>k){
            bfr=before(bfrstk);
        }
        if(sum<k){
            nxt=next(nxtstk);
        }
    }
    return false;
    }
    public void pushAllLeft(TreeNode root,Stack<TreeNode> stk){
        if(root==null){
            return;
        }
        TreeNode temp=root;
        while(temp!=null){
            stk.push(temp);
            temp=temp.left;
        }
    }

    public void pushAllRight(TreeNode root,Stack<TreeNode> stk){
         if(root==null){
            return;
        }
        TreeNode temp=root;
        while(temp!=null){
            stk.push(temp);
            temp=temp.right;
        }
    }

    public int next(Stack<TreeNode> stk){
        if(stk.isEmpty()){
            return -1;
        }
        TreeNode curr=stk.pop();
        pushAllLeft(curr.right,stk);
        return curr.val;
    }
    
    public int before(Stack<TreeNode> stk){
        if(stk.isEmpty()){
            return -1;
        }
        TreeNode curr=stk.pop();
        pushAllRight(curr.left,stk);
        return curr.val;
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1:
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(7);
        System.out.println(solution.findTarget(root1, 9));  // Expected output: true
        
        // Test case 2:
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        System.out.println(solution.findTarget(root2, 4));  // Expected output: false
        
        // Test case 3:
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(0);
        root3.right = new TreeNode(2);
        System.out.println(solution.findTarget(root3, 3));  // Expected output: true
    }
}
