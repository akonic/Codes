class Solution {
    int ans;
    public void shuffle(boolean[] visited,int count,int n)
    {
        if(count==n+1)
        {
            ans++;
            return;
        }
        for(int i=1;i<=n;i++)
        {
            if(!visited[i] && (i%count==0 || count%i==0))
            {
                visited[i]=true;    
                shuffle(visited,count+1,n);
                visited[i]=false;
            }
        }
    }
    public int countArrangement(int n) {
        ans=0;
        boolean[] visited = new boolean[n+1];
        shuffle(visited,1,n);
        return ans;
    }
}