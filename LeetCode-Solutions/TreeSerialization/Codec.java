import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

/**
 * This class provides methods to serialize and deserialize a binary tree.
 * 
 * @author [Your Name]
 */
public class Codec {
    /**
     * Encodes a tree to a single string.
     * 
     * Approach: Uses a level-order traversal (BFS) to serialize the tree. It uses a queue to keep track of nodes at each level.
     * Time Complexity: O(N), where N is the number of nodes in the tree, since we visit each node once.
     * Space Complexity: O(N), where N is the number of nodes in the tree, since in the worst case, the queue will store all nodes at the last level.
     * 
     * @param root the root of the binary tree
     * @return a string representation of the binary tree
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        ArrayList<String> arr=new ArrayList<>();
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        arr.add(Integer.toString(root.val));
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.left==null){
                arr.add("null");
            }
            else if(curr.left!=null){
                arr.add(Integer.toString(curr.left.val));
                q.offer(curr.left);
            }
             if(curr.right==null){
                arr.add("null");
            }
           
            else  if(curr.right!=null){
                arr.add(Integer.toString(curr.right.val));
                q.offer(curr.right);
                }
        }
        String ans = String.join(",", arr);
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return  null;
        }
        String[] arr=data.split(",");
          if(arr[0].equals("null")){
            return null;
        }
        Queue<TreeNode> q=new ArrayDeque<>();
        
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        int i=1;
      

        q.offer(root);

        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(i<arr.length && !arr[i].equals("null")){
                curr.left=new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.left);
            }
            i++;
            if(i<arr.length && !arr[i].equals("null")){
                curr.right=new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
    }
    
    /**
     * Decodes your encoded data to tree.
     * 
     * Approach: Uses a level-order traversal (BFS) to deserialize the tree. It uses a queue to keep track of nodes at each level.
     * Time Complexity: O(N), where N is the number of nodes in the tree, since we visit each node once.
     * Space Complexity: O(N), where N is the number of nodes in the tree, since in the worst case, the queue will store all nodes at the last level.
     * 
     * @param data a string representation of the binary tree
     * @return the root of the deserialized binary tree
     */
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        ArrayList<String> arr=new ArrayList<>();
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        arr.add(Integer.toString(root.val));
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.left==null){
                arr.add("null");
            }
            else if(curr.left!=null){
                arr.add(Integer.toString(curr.left.val));
                q.offer(curr.left);
            }
             if(curr.right==null){
                arr.add("null");
            }
           
            else  if(curr.right!=null){
                arr.add(Integer.toString(curr.right.val));
                q.offer(curr.right);
                }
        }
        String ans = String.join(",", arr);
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return  null;
        }
        String[] arr=data.split(",");
          if(arr[0].equals("null")){
            return null;
        }
        Queue<TreeNode> q=new ArrayDeque<>();
        
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        int i=1;
      

        q.offer(root);

        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(i<arr.length && !arr[i].equals("null")){
                curr.left=new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.left);
            }
            i++;
            if(i<arr.length && !arr[i].equals("null")){
                curr.right=new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
    }
}

public class Driver {
    public static void main(String[] args) {
        Codec ser = new Codec();
        Codec deser = new Codec();
        
        // Test case 1: Empty tree
        TreeNode root1 = null;
        String serialized1 = ser.serialize(root1);
        TreeNode deserialized1 = deser.deserialize(serialized1);
        System.out.println("Deserialized tree 1: " + deserialized1);
        
        // Test case 2: Tree with one node
        TreeNode root2 = new TreeNode(1);
        String serialized2 = ser.serialize(root2);
        TreeNode deserialized2 = deser.deserialize(serialized2);
        System.out.println("Deserialized tree 2: " + deserialized2.val);
        
        // Test case 3: Tree with multiple nodes
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.left.left = new TreeNode(4);
        root3.left.right = new TreeNode(5);
        String serialized3 = ser.serialize(root3);
        TreeNode deserialized3 = deser.deserialize(serialized3);
        System.out.println("Deserialized tree 3: ");
        printTree(deserialized3);
    }
    
    public static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}