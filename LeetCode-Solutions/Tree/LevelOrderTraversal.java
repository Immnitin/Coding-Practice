import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;

/**
 * This class provides a solution for the level order traversal of a binary tree.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class LevelOrderTraversal {
    /**
     * This method performs a level order traversal of a binary tree.
     * 
     * <p>Approach: Uses a Queue to perform a breadth-first traversal of the binary tree.
     * The algorithm starts by adding the root node to the queue. Then, it enters a loop where it
     * dequeues a node, adds its value to the result list, and enqueues its children. This process
     * continues until the queue is empty, at which point all nodes have been visited.
     * 
     * <p>Time Complexity: O(N), where N is the number of nodes in the binary tree. This is because
     * each node is visited once.
     * 
     * <p>Space Complexity: O(N), where N is the number of nodes in the binary tree. This is because
     * in the worst case, the queue will contain all nodes at the last level of the tree.
     * 
     * @param root The root of the binary tree.
     * @return A list of lists, where each inner list contains the values of the nodes at a given level.
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q=new ArrayDeque<>();
        List<List<Integer>> res=new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int leveltocheck=q.size();
            List<Integer> arr=new ArrayList<>();
            for(int i=0;i<leveltocheck;i++){
                if(q.peek().left!=null) {q.add(q.peek().left);}
                if(q.peek().right!=null) q.add(q.peek().right);
                arr.add(q.poll().val);
            }
            res.add(arr);
        }
        return res;
    }
}

    public static class Driver {
        public static void main(String[] args) {
            Solution solution = new Solution();
            // Test case 1: Empty tree
            System.out.println(solution.levelOrder(null));
            // Test case 2: Tree with one node
            TreeNode root1 = new TreeNode(1);
            System.out.println(solution.levelOrder(root1));
            // Test case 3: Tree with multiple nodes
            TreeNode root2 = new TreeNode(3);
            root2.left = new TreeNode(9);
            root2.right = new TreeNode(20);
            root2.right.left = new TreeNode(15);
            root2.right.right = new TreeNode(7);
            System.out.println(solution.levelOrder(root2));
        }
    }
}