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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        head = head.next;
        int c=1;
        int[] ans = new int[2];
        ans[0]=-1;
        ans[1]=-1;
        int x=Integer.MAX_VALUE;
        int y=Integer.MIN_VALUE;
        int u=Integer.MAX_VALUE;
        int p=0;
        int prv=-1;
        while(head!=null)
        {
            if(head.next!=null)
            {
                if(head.val>prev.val && head.val > head.next.val)
                {p++;
                    y=Math.max(y,c);
                    if(prv!=-1)
                    {
                        x=Math.min(x,c-prv);
                    }
                    prv=c;
                    u=Math.min(u,c);
                    
                }
                if(head.val<prev.val && head.val < head.next.val)
                {p++;
                     if(prv!=-1)
                    {
                        x=Math.min(x,c-prv);
                    }
                    prv=c;
                   y=Math.max(y,c);u=Math.min(u,c);
                    
                }

            }
            prev=head;
            head=head.next;
            c++;
        }      
        if(p==0 || p==1)
        {
            return ans;
        }
        ans[0]=x;
        ans[1]=y-u;
        return ans;
    }
}