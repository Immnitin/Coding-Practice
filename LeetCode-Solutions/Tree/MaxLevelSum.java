import java.util.Queue;
import java.util.ArrayDeque;
/**
 * This class provides a solution to the problem of finding the level with the maximum sum in a binary tree.
 * 
 * @author [Your Name]
 * @version 1.0
 */
/**
 * Approach: Uses a level order traversal (Breadth-First Search) to calculate the sum of each level in the binary tree.
 * The level with the maximum sum is tracked and returned as the result.
 * 
 * Time Complexity: O(N), where N is the number of nodes in the binary tree, since each node is visited once.
 * 
 * Space Complexity: O(W), where W is the width of the binary tree, since in the worst case, the queue will store all nodes at the last level.
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
    public int maxLevelSum(TreeNode root) {
         Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        int max=Integer.MIN_VALUE;
        int lev=1;
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            int sum=0;
            for(int i=0;i<size;i++){
                if(q.peek().left!=null){q.offer(q.peek().left);}
                if(q.peek().right!=null){q.offer(q.peek().right);}
                sum+=q.poll().val;
            }
            // System.out.println("sum "+sum+" max "+max+" level "+level);
            if(sum>max){
                lev=level;
                max=sum;
            }
            level++;
        }
        return lev;
    }
}

/**
 * Driver class to test the MaxLevelSum solution.
 */
class Driver {
    public static void main(String[] args) {
        // Test case 1:
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        Solution solution = new Solution();
        System.out.println("Max level sum: " + solution.maxLevelSum(root1));

        // Test case 2:
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5
        // / \
        //6   7
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.left.left.left = new TreeNode(6);
        root2.left.left.right = new TreeNode(7);
        System.out.println("Max level sum: " + solution.maxLevelSum(root2));
    }
}