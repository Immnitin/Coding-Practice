import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;

/**
 * This class provides a solution to the Zigzag Level Order Traversal problem.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class Solution {
    /**
     * This method performs a zigzag level order traversal on a binary tree.
     * 
     * Approach: Uses a Queue to perform a level order traversal and a List to store the result. The level of the tree is tracked to determine whether to reverse the current level or not.
     * 
     * Time Complexity: O(N), where N is the number of nodes in the tree, since each node is visited once.
     * 
     * Space Complexity: O(N), where N is the number of nodes in the tree, since in the worst case, the queue will store all nodes at the last level.
     * 
     * @param root The root of the binary tree.
     * @return A list of lists, where each sublist contains the node values at a given level in zigzag order.
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q=new ArrayDeque<>();
        List<List<Integer>> res=new ArrayList<>();
        q.offer(root);
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> ans=new ArrayList<>();
            for(int i=0;i<size;i++){
                if(q.peek().left!=null){q.offer(q.peek().left);}
                if(q.peek().right!=null){q.offer(q.peek().right);}
                ans.add(q.poll().val);
            }
            if(level%2!=0){
                res.add(ans);
            }
            else {
                Collections.reverse(ans);
                res.add(ans);}
            level++;
        }
        return res;
    }
}
}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test case 1:
        //      3
        //     / \ 
        //    9  20
        //       /  \ 
        //      15   7
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(solution.zigzagLevelOrder(root1));
        
        // Test case 2:
        //      1
        //     / \ 
        //    2  3
        //       / \ 
        //      4   5
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        System.out.println(solution.zigzagLevelOrder(root2));
        
        // Test case 3:
        //      1
        //     / \ 
        //    2  3
        //   /   / \ 
        //  4   5   6
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.left.left = new TreeNode(4);
        root3.right.left = new TreeNode(5);
        root3.right.right = new TreeNode(6);
        System.out.println(solution.zigzagLevelOrder(root3));
    }
}