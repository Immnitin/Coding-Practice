
import java.util.*;

/**
 * This class provides a solution to the problem of removing the nth node from the end of a linked list.
 * 
 * Approach: 
 * Uses the two-pointer technique to track the nth node from the end. 
 * It initializes two pointers, fast and slow, to the head of the list. 
 * The fast pointer moves n steps ahead, and then both pointers move one step at a time until the fast pointer reaches the end of the list. 
 * At this point, the slow pointer is at the node right before the nth node from the end, which can then be removed.
 * 
 * Time Complexity: 
 * O(L), where L is the length of the linked list, because each node is visited at most twice.
 * 
 * Space Complexity: 
 * O(1), because only a constant amount of space is used to store the pointers and other variables.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
       if(head==null){
        return head;
       }
       if(head.next==null && n==1){
        return null;
       }
       if(head.next.next==null){
        if(n==1){
            head.next=null;
            return head;
        }
        else if(n==2){
            return head.next;
        }
       }
       ListNode fast=dummy;
       ListNode slow=dummy;
       for(int i=0;i<n;i++){
        if(fast.next!=null)
        {fast=fast.next;}
       }
       if(fast.next==null){
        head=head.next;
        return head;
       }
       while(fast!=null && fast.next!=null){
        fast=fast.next;
        slow=slow.next;
       }
       slow.next=slow.next.next;
       return dummy.next;
    }
}

class Driver {
   public static void main(String[] args) {
       Solution solution = new Solution();
       // Test case 1: Remove the last node
       ListNode head1 = new ListNode(1);
       head1.next = new ListNode(2);
       head1.next.next = new ListNode(3);
       head1.next.next.next = new ListNode(4);
       head1.next.next.next.next = new ListNode(5);
       ListNode result1 = solution.removeNthFromEnd(head1, 1);
       while (result1 != null) {
           System.out.print(result1.val + " ");
           result1 = result1.next;
       }
       System.out.println();

       // Test case 2: Remove the first node
       ListNode head2 = new ListNode(1);
       head2.next = new ListNode(2);
       head2.next.next = new ListNode(3);
       head2.next.next.next = new ListNode(4);
       head2.next.next.next.next = new ListNode(5);
       ListNode result2 = solution.removeNthFromEnd(head2, 5);
       while (result2 != null) {
           System.out.print(result2.val + " ");
           result2 = result2.next;
       }
       System.out.println();

       // Test case 3: Remove the middle node
       ListNode head3 = new ListNode(1);
       head3.next = new ListNode(2);
       head3.next.next = new ListNode(3);
       head3.next.next.next = new ListNode(4);
       head3.next.next.next.next = new ListNode(5);
       ListNode result3 = solution.removeNthFromEnd(head3, 3);
       while (result3 != null) {
           System.out.print(result3.val + " ");
           result3 = result3.next;
       }
       System.out.println();
   }
}