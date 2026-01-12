import java.util.ArrayList;
import java.util.List;
/**
 * This class provides a solution to the binary tree paths problem.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class BinaryTreePaths {
    /**
     * Returns a list of strings representing all root-to-leaf paths in a binary tree.
     * 
     * Approach: Uses a depth-first search (DFS) approach to traverse the binary tree and construct the paths.
     * Time Complexity: O(N), where N is the number of nodes in the tree, since we visit each node once.
     * Space Complexity: O(N), where N is the number of nodes in the tree, since in the worst case, the tree is completely unbalanced, e.g., each node has only left child node, the recursion call would occur N times (the height of the tree), therefore storage to store the call stack would be O(N). In the best case, the tree is completely balanced, the height of the tree would be log(N). Therefore, the space complexity in this case would be O(log(N)).
     * 
     * @param root the root of the binary tree
     * @return a list of strings representing all root-to-leaf paths in the binary tree
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        path(root,res,ans);
        List<String> fans=new ArrayList<>();
        for(int i=0;i<ans.size();i++){
            int j=0;
            StringBuilder sb=new StringBuilder();
            for(j=0;j<ans.get(i).size()-1;j++){
                sb.append(ans.get(i).get(j)+"->");
            }
            sb.append(ans.get(i).get(j));
            fans.add(sb.toString());
        }
        return fans;
    }
    public void path(TreeNode root,List<Integer> res,List<List<Integer>> ans){
        if(root==null){
            return;
        }
        res.add(root.val);
        // System.out.println("res "+res+" ans "+ans);
        path(root.left,res,ans);
        path(root.right,res,ans);
        if(root.left==null && root.right==null){
            ans.add(new ArrayList<>(res));
        }
        res.remove(res.size()-1);
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
        System.out.println(solution.binaryTreePaths(root1));
        // Test case 2:
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        System.out.println(solution.binaryTreePaths(root2));
        // Test case 3:
        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(2);
        System.out.println(solution.binaryTreePaths(root3));
    }
}