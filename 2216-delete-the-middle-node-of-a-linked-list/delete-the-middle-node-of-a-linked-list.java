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
    public ListNode deleteMiddle(ListNode head) {
        int n=0;
        ListNode temp = head;
        while(temp!=null)
        {
            n++;
            temp=temp.next;
        }
        int mid = n/2;
        if(mid==0)
        {
            return null;
        }
        temp=head.next;
        ListNode prev = head;
        mid--;
        while(mid!=0)
        {
            mid--;
            ListNode next = temp.next;
            prev=temp;
            temp=next;
        }
        prev.next=temp.next;
        return head;
    }
}