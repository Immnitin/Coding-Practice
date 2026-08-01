import java.util.*;
/**
 * Definition for adding two numbers represented as linked lists.
 * <p>
 * Approach: This solution uses a simple iterative approach to add two numbers represented as linked lists.
 * It iterates through both linked lists, adding corresponding nodes and handling any carry-over values.
 * <p>
 * Time Complexity: O(max(m, n)), where m and n are the lengths of the two linked lists.
 * Space Complexity: O(max(m, n)), as in the worst case, the resulting linked list can have a length of max(m, n) + 1.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode d1=l1;
        ListNode d2=l2;
        ListNode res=new ListNode(-1);
        ListNode ans=res;
        int borrow=0;
        while(d1!=null && d2!=null){
            int n1=d1.val;
            int n2=d2.val;

            int sum=n1+n2+borrow;
            ListNode temp;
            if(sum>=10){
                temp=new ListNode(sum%10);
                borrow=sum/10;
            }
            else{
                temp=new ListNode(sum);
                borrow=0;
            }
            ans.next=temp;
            ans=ans.next;
            d1=d1.next;
            d2=d2.next;
        }        

        while(d1!=null){
            int sum=d1.val+borrow;
             ListNode temp;
            if(sum>=10){
                temp=new ListNode(sum%10);
                borrow=sum/10;
            }
            else{
                temp=new ListNode(sum);
                borrow=0;
            }
            ans.next=temp;
            ans=ans.next;
            d1=d1.next;

        }

        while(d2!=null){
             int sum=d2.val+borrow;
             ListNode temp;
            if(sum>=10){
                temp=new ListNode(sum%10);
                borrow=sum/10;
            }
            else{
                temp=new ListNode(sum);
                borrow=0;
            }
            ans.next=temp;
            ans=ans.next;
            d2=d2.next;
        }

        if(borrow>0){
            ListNode b=new ListNode(borrow);
            ans.next=b;
        }
        return res.next;
    }

}

public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test case 1: 342 + 465 = 807
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result1 = solution.addTwoNumbers(l1, l2);
        while (result1 != null) {
            System.out.print(result1.val + " ");
            result1 = result1.next;
        }
        System.out.println();

        // Test case 2: 0 + 0 = 0
        l1 = new ListNode(0);
        l2 = new ListNode(0);
        ListNode result2 = solution.addTwoNumbers(l1, l2);
        while (result2 != null) {
            System.out.print(result2.val + " ");
            result2 = result2.next;
        }
        System.out.println();

        // Test case 3: 99 + 1 = 100
        l1 = new ListNode(9, new ListNode(9));
        l2 = new ListNode(1);
        ListNode result3 = solution.addTwoNumbers(l1, l2);
        while (result3 != null) {
            System.out.print(result3.val + " ");
            result3 = result3.next;
        }
    }
}