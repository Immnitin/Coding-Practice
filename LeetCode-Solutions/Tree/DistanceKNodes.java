
import java.util.*;

/**
 * This class provides a solution to the problem of finding all nodes in a binary tree that are at a distance K from a given target node.
 * 
 * Approach: 
 * The algorithm uses a combination of depth-first search (DFS) and breadth-first search (BFS) to solve the problem. 
 * It first uses DFS to find the target node in the tree, then uses BFS to traverse the tree and find all nodes at a distance K from the target node.
 * 
 * Time Complexity: 
 * The time complexity of this solution is O(N), where N is the number of nodes in the tree. 
 * This is because in the worst case, we need to traverse all nodes in the tree.
 * 
 * Space Complexity: 
 * The space complexity of this solution is O(N), where N is the number of nodes in the tree. 
 * This is because we need to store the parent of each node in a hashmap, and in the worst case, we need to store all nodes in the hashmap.
 */
public class DistanceKNodes {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class Info{
        TreeNode root;
        int dist;
        public Info(TreeNode root,int dist){
            this.root=root;
            this.dist=dist;
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        TreeNode[] st=new TreeNode[1];
        preorder(root,target,st);
        TreeNode stnode= st[0];
        HashMap<TreeNode,TreeNode> mp=new HashMap<>();
        markParents(root,mp);
        Queue<Info> q=new ArrayDeque<>();
        q.offer(new Info(stnode,0));
        HashMap<TreeNode,Boolean> visited=new HashMap<>();
        visited.put(stnode,true);
        List<Integer> res=new ArrayList<Integer>();
        while(!q.isEmpty()){
            Info currnode=q.poll();
            TreeNode curr=currnode.root;
            int dist=currnode.dist;
            if(dist==k){
                res.add(curr.val);
            }
            if(curr.left!=null){
                if(visited.containsKey(curr.left)==false || visited.get(curr.left)==false){
                    visited.put(curr.left,true);
                    q.offer(new Info(curr.left,dist+1));
                }
            }
            if(curr.right!=null){
                if(visited.containsKey(curr.right)==false || visited.get(curr.right)==false){
                    visited.put(curr.right,true);
                    q.offer(new Info(curr.right,dist+1));
                }
            }
            if(mp.get(curr)!=null){
                TreeNode parent=mp.get(curr);
                if(visited.containsKey(parent)==false || visited.get(parent)==false){
                    visited.put(parent,true);
                    q.offer(new Info(parent,dist+1));
                }
            }
        }
        return res;
        
    }
    public void markParents(TreeNode root,HashMap<TreeNode,TreeNode> mp){
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        mp.put(root,null);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.left!=null){
                mp.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                mp.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
    }

    public void preorder(TreeNode root, TreeNode target,TreeNode[] stnode){
        if(root==null){
            return;
        }
        if(root.val==target.val){
            stnode[0]=root;
            return ;
        }
        preorder(root.left,target,stnode);
        preorder(root.right,target,stnode);
    }
}

    public static class Driver {
        public static void main(String[] args) {
            Solution solution = new Solution();
            // Test case 1:
            TreeNode root1 = new TreeNode(3);
            root1.left = new TreeNode(5);
            root1.right = new TreeNode(1);
            root1.left.left = new TreeNode(6);
            root1.left.right = new TreeNode(2);
            root1.right.left = new TreeNode(0);
            root1.right.right = new TreeNode(8);
            root1.left.right.left = new TreeNode(7);
            root1.left.right.right = new TreeNode(4);
            TreeNode target1 = root1.left;
            int k1 = 2;
            System.out.println(solution.distanceK(root1, target1, k1));  // Output: [7, 4, 1]

            // Test case 2:
            TreeNode root2 = new TreeNode(1);
            TreeNode target2 = root2;
            int k2 = 1;
            System.out.println(solution.distanceK(root2, target2, k2));  // Output: []

            // Test case 3:
            TreeNode root3 = new TreeNode(1);
            root3.left = new TreeNode(2);
            root3.right = new TreeNode(3);
            TreeNode target3 = root3;
            int k3 = 1;
            System.out.println(solution.distanceK(root3, target3, k3));  // Output: [2, 3]
        }
    }
}
