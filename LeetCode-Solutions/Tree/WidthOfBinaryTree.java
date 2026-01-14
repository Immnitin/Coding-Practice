
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * This class calculates the width of a binary tree.
 * 
 * Approach: Uses a level order traversal (BFS) to track the indices of the nodes at each level.
 *          The width of the tree is the maximum difference between the indices of the rightmost and leftmost nodes at any level.
 * Time Complexity: O(N), where N is the number of nodes in the tree, since we visit each node once.
 * Space Complexity: O(N), where N is the number of nodes in the tree, since in the worst case, the queue will store all nodes at the last level.
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
    class Pair{
        TreeNode root;
        int idx;
        public Pair(TreeNode root, int idx){
            this.root=root;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
       Deque<Pair> q=new ArrayDeque<>();
       q.push(new Pair(root,0));
       int maxw=0;
       while(!q.isEmpty()){
        int size=q.size();
        for(int i=0;i<size;i++){
            if(q.peekFirst().root.left!=null){q.offerLast(new Pair(q.peekFirst().root.left,2*q.peekFirst().idx+1));}
            if(q.peekFirst().root.right!=null){q.offerLast(new Pair(q.peekFirst().root.right,2*q.peekFirst().idx+2));}
            q.pollFirst();
        }
                if(!q.isEmpty())
        {
            maxw=Math.max(maxw,(q.peekLast().idx-q.peekFirst().idx+1));}
       }
       return maxw; 
    }
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1:
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(9);
        System.out.println("Width of binary tree 1: " + solution.widthOfBinaryTree(root1));
        
        // Test case 2:
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(5);
        System.out.println("Width of binary tree 2: " + solution.widthOfBinaryTree(root2));
        
        // Test case 3:
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(3);
        root3.right = new TreeNode(2);
        root3.right.right = new TreeNode(9);
        System.out.println("Width of binary tree 3: " + solution.widthOfBinaryTree(root3));
    }
}
