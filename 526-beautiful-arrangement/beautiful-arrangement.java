class Solution {
    int ans;
    private boolean check(List<Integer> ls)
    {
        int n=ls.size();
        for(int i=0;i<n;i++)
        {
            int x=ls.get(i);
            if(x%(i+1)==0 || (i+1)%x==0)
            {

            }
            else{
                return false;
            }
        }
        return true;
    }
    public void shuffle(List<Integer> ls,boolean[] visited,int count,int n)
    {
        if(count==n)
        {
            
                ans++;
            return;
        }
        for(int i=1;i<=n;i++)
        {
            if(!visited[i] )
            {
                visited[i]=true;
                ls.add(i);
                if(check(ls)) 
                {
                    shuffle(ls,visited,count+1,n);
                }
                ls.remove(ls.size()-1);
                visited[i]=false;
            }
        }
    }
    public int countArrangement(int n) {
        ans=0;
        List<Integer> ls = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        shuffle(ls,visited,0,n);
        return ans;
    }
}