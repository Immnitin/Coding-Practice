
import java.util.*;

/**
 * This class provides a solution to reverse a linked list in k-group chunks.
 * 
 * Approach: 
 * The algorithm used here is to first calculate the total number of nodes in the linked list, 
 * then calculate the number of complete groups that can be formed with k nodes in each group, 
 * and the remaining nodes. It then iterates over the linked list, reversing each group of k nodes.
 * 
 * Time Complexity: 
 * The time complexity of this solution is O(n), where n is the total number of nodes in the linked list.
 * This is because we are traversing the linked list twice: once to calculate the total number of nodes, 
 * and once to reverse the groups of k nodes.
 * 
 * Space Complexity: 
 * The space complexity of this solution is O(1), which means the space required does not change with the size of the input linked list.
 * This is because we are only using a constant amount of space to store the pointers and variables.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=head;
        int size=0;
        while(dummy!=null){
            size++;
            dummy=dummy.next;
        }
        int groups=size/k;
        int rem=size-(groups*k);

        ListNode curr=head;
        ListNode prev=null;
        ListNode prevHead=head;
        ListNode next=null;
        int i=1;

        while(i<=k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            i++;
        }
        head=prev;
        for(int m=2;m<=groups;m++){
            ListNode groupTail= curr;
            prev=null;
            int j=1;
            while(j<=k){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
                j++;
            }
            prevHead.next=prev;
            prevHead=groupTail;
        }
            prevHead.next=curr;
    
            return head;

    }

    
}

class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1:
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        ListNode result1 = solution.reverseKGroup(head1, 2);
        while (result1 != null) {
            System.out.print(result1.val + " ");
            result1 = result1.next;
        }
        System.out.println();
        
        // Test case 2:
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        ListNode result2 = solution.reverseKGroup(head2, 3);
        while (result2 != null) {
            System.out.print(result2.val + " ");
            result2 = result2.next;
        }
        System.out.println();
        
        // Test case 3:
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        head3.next.next.next = new ListNode(4);
        head3.next.next.next.next = new ListNode(5);
        ListNode result3 = solution.reverseKGroup(head3, 1);
        while (result3 != null) {
            System.out.print(result3.val + " ");
            result3 = result3.next;
        }
        System.out.println();
    }
}
