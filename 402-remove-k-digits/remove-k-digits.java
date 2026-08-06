class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        char[] ch = num.toCharArray();
        int i=0;
        int n= ch.length;
        while(i<n)
        {
            int p=ch[i]-'0';
            while(!q.isEmpty() && p<q.peek() && k>0)
            {
                q.pop();
                k--;
            }
            q.push(p);
            i++;
        }while(k>0)
        {
            k--;
            q.pop();
        }
        i=0;
        int sz=q.size();
        if(sz==0)
        {
            return "0";
        }
        int[] ap = new int[sz];
        while(!q.isEmpty())
        {
            ap[i]=q.pop();
            i++;
        }
        
        i=sz-1;
        while(i>0 && ap[i]==0)
        {
            i--;
        }

        StringBuilder ans =  new StringBuilder();  
        while(i>=0)
        {
            ans.append(ap[i]);
            i--;
        }              

        return ans.toString();
    }
}