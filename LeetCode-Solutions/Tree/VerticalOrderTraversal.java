
import java.util.*;

/**
 * This class provides a solution to the Vertical Order Traversal problem.
 * 
 * Approach: 
 * Uses a level order traversal (BFS) approach with a queue to traverse the tree. 
 * It also uses a HashMap to store the nodes at each horizontal distance.
 * 
 * Time Complexity: 
 * O(N log N) due to the sorting of the nodes at each horizontal distance.
 * 
 * Space Complexity: 
 * O(N) for storing the nodes in the queue and the HashMap.
 * 
 * @author [Your Name]
 * @version [Current Version]
 */
public class Solution {
    // /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     class pair{
//         TreeNode root;
//         int hd;
//         public pair(TreeNode root, int hd){
//             this.root=root;
//             this.hd=hd;
//         }
//     }
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//      HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
//      Queue<pair> q=new ArrayDeque<>();
//      List<List<Integer>> res=new ArrayList<>();
//      map.put(0,new ArrayList<>(Arrays.asList(root.val)));
//     q.offer(new pair(root,0));
//     while(!q.isEmpty()){
//         int size=q.size();
//         for(int i=0;i<size;i++){
//             int roothd=q.peek().hd;
//             if(q.peek().root.left!=null){
//                 q.offer(new pair(q.peek().root.left,roothd-1));
//                 map.computeIfAbsent(roothd-1,k->new ArrayList<>()).add(q.peek().root.left.val);
//             }
//             if(q.peek().root.right!=null){
//                 q.offer(new pair(q.peek().root.right,roothd+1));
//                 map.computeIfAbsent(roothd+1,k-> new ArrayList<>()).add(q.peek().root.right.val);
//             }
//             q.poll();
//         }
//     }
//         // System.out.println(map);
//        List<Integer> keys = new ArrayList<>(map.keySet());
// Collections.sort(keys);
// for(int key : keys){
//     List<Integer> lis=new ArrayList<>(map.get(key));
//     Collections.sort(lis);
//     res.add(lis);
// }
//         return res;
//     }
// }

class Solution {
    class Pair {
        TreeNode node;
        int hd, row;
        Pair(TreeNode node, int hd, int row) {
            this.node = node;
            this.hd = hd;
            this.row = row;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int hd = curr.hd, row = curr.row;

            map.computeIfAbsent(hd, k -> new ArrayList<>()).add(new int[]{row, node.val});

            if (node.left != null) q.offer(new Pair(node.left, hd - 1, row + 1));
            if (node.right != null) q.offer(new Pair(node.right, hd + 1, row + 1));
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        List<List<Integer>> res = new ArrayList<>();
        for (int key : keys) {
            List<int[]> list = map.get(key);
            list.sort((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0]; // row first
                return a[1] - b[1];                   // value tie-break
            });
            List<Integer> col = new ArrayList<>();
            for (int[] pair : list) col.add(pair[1]);
            res.add(col);
        }

        return res;
    }
}

}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1:
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("Test case 1:");
        System.out.println(solution.verticalTraversal(root1));
        
        // Test case 2:
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(7);
        System.out.println("Test case 2:");
        System.out.println(solution.verticalTraversal(root2));
        
        // Test case 3:
        TreeNode root3 = new TreeNode(0);
        root3.left = new TreeNode(8);
        root3.right = new TreeNode(1);
        root3.left.right = new TreeNode(3);
        root3.right.left = new TreeNode(4);
        root3.right.right = new TreeNode(2);
        root3.left.right.left = new TreeNode(5);
        root3.left.right.right = new TreeNode(6);
        root3.right.left.right = new TreeNode(7);
        System.out.println("Test case 3:");
        System.out.println(solution.verticalTraversal(root3));
    }
}
