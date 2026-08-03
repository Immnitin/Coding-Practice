
import java.util.*;

/**
 * This class provides a solution to the problem of rotating a linked list to the right by a given number of steps.
 * 
 * Approach: 
 * The solution uses a two-pointer technique to rotate the linked list. It first calculates the length of the list and 
 * checks if the number of steps is a multiple of the length. If it is, the list remains the same. Otherwise, it calculates 
 * the new tail of the list and the new head, and then reconnects the nodes to form the rotated list.
 * 
 * Time Complexity: 
 * The time complexity of this solution is O(n), where n is the number of nodes in the linked list. This is because we 
 * traverse the list twice: once to calculate its length and once to rotate it.
 * 
 * Space Complexity: 
 * The space complexity of this solution is O(1), which means the space required does not change with the size of the 
 * input list. This is because we only use a constant amount of space to store the pointers and the length of the list.
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        int size=0;
        ListNode dummy=head;
        while(dummy!=null){
            dummy=dummy.next;
            size++;
        }

        if(k%size==0){
            return head;
        }

        int pos=k%size;
        
        int diff=size-pos;

        ListNode fast=head;
        ListNode prev=head;
        ListNode slow=head;

        int i=1;
        while(i<=diff){
            prev=fast;
            fast=fast.next;
            if(i==diff){
                prev.next=null;
            }
            i++;
        }
        head=fast;
        while(fast!=null && fast.next!=null){
            fast=fast.next;
        }
        if(fast!=null){
            fast.next=slow;
        }

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
        System.out.println("Rotated List: ");
        printList(solution.rotateRight(head1, 2));
        
        // Test case 2:
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println("Rotated List: ");
        printList(solution.rotateRight(head2, 1));
        
        // Test case 3:
        ListNode head3 = new ListNode(1);
        System.out.println("Rotated List: ");
        printList(solution.rotateRight(head3, 1));
    }
    
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
