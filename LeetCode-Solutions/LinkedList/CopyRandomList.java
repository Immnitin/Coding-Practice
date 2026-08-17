
import java.util.HashMap;

/**
 * This class provides a solution to the problem of copying a linked list with random pointers.
 * 
 * Approach: Uses a two-pass approach with a HashMap to store the mapping between original nodes and their copies.
 *           The first pass creates copies of all nodes and stores them in the HashMap. The second pass sets the random pointers.
 * Time Complexity: O(N), where N is the number of nodes in the linked list, since we visit each node twice.
 * Space Complexity: O(N), since we store all nodes in the HashMap.
 */
public class Solution {
    /*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
     public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();

        Node dummy = head;
        Node newHead = new Node(-1);
        Node copyDummy = newHead;

        // First pass: Create copied nodes and store Original -> Copy mapping
        while (dummy != null) {
            Node temp = new Node(dummy.val);
            map.put(dummy, temp);

            copyDummy.next = temp;
            copyDummy = copyDummy.next;
            dummy = dummy.next;
        }

        // Second pass: Set random pointers
        dummy = head;
        copyDummy = newHead.next;

        while (dummy != null) {
            if (dummy.random != null) {
                copyDummy.random = map.get(dummy.random);
            } else {
                copyDummy.random = null;
            }

            dummy = dummy.next;
            copyDummy = copyDummy.next;
        }

        return newHead.next;
    }
}
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: A simple linked list with random pointers
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.random = head1.next.next;
        head1.next.random = head1;
        head1.next.next.random = head1.next;

        Node copiedHead1 = solution.copyRandomList(head1);

        // Test case 2: A linked list with no random pointers
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);

        Node copiedHead2 = solution.copyRandomList(head2);

        // Test case 3: A linked list with a single node and a random pointer to itself
        Node head3 = new Node(1);
        head3.random = head3;

        Node copiedHead3 = solution.copyRandomList(head3);
    }
}
