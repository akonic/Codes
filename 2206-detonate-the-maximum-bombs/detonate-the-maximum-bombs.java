class Solution {
    public int dfs(ArrayList<ArrayList<Integer>> adj,int[] visited,int i)
    {
        visited[i]=1;
        int ans=1;
        for(int j : adj.get(i))
        {
            if(visited[j]==0)
            {
                ans+=dfs(adj,visited,j);
            }
        }
        return ans;

    }
    public int maximumDetonation(int[][] bombs) {
        int n=bombs.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] visited = new int[n];
        for(int i=0;i<n;i++)
        {
            visited[i]=0;
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            long  x=bombs[i][0];
            long  y=bombs[i][1];
            long  r=bombs[i][2];

            for(int j=i+1;j<n;j++)
            {
                long  x2=bombs[j][0];
                long  y2=bombs[j][1];
                long  r2=bombs[j][2];
                if((x-x2)*(x-x2) + (y-y2)*(y-y2) <= r*r)
                {
                    adj.get(i).add(j);
                }
                if((x-x2)*(x-x2) + (y-y2)*(y-y2) <= r2 *r2)
                {
                    adj.get(j).add(i);
                }
            }
        }

        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            
            ans=Math.max(ans,dfs(adj,visited,i));
            Arrays.fill(visited,0);
            
        }
        
        return ans;
    }
}