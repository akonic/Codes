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
        List<Integer> ls = new ArrayList<>();
        ListNode prev = head;
        head = head.next;
        int c=1;
        while(head!=null)
        {
            if(head.next!=null)
            {
                if(head.val>prev.val && head.val > head.next.val)
                {
                   
                    ls.add(c);
                }
                if(head.val<prev.val && head.val < head.next.val)
                {
                   
                    ls.add(c);
                }

            }
            prev=head;
            head=head.next;
            c++;
        }

        int n= ls.size();
        int[] ans = new int[2];
        ans[0]=-1;
        ans[1]=-1;
        if(n==0 || n==1)
        {
            return ans;
        }

        int x=Integer.MAX_VALUE;
        int y = Integer.MIN_VALUE;
        for(int i=1;i<n;i++)
        {
            x=Math.min(x,ls.get(i)-ls.get(i-1));
           // y=Math.max(y,ls.get(i)-ls.get(i-1));
        }
        y=ls.get(n-1)-ls.get(0);
        ans[0]=x;
        ans[1]=y;
        return ans;
    }
}