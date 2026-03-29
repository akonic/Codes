class Solution {
    int c;
    private void helper(ArrayList<ArrayList<Integer>> adj,int[] visited,int i)
    {
        visited[i]=1;
        c--;
        for(int j : adj.get(i))
        {
            if(visited[j]==0)
            {
                helper(adj,visited,j);
            }
        }
    }
    public long countPairs(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] visited = new int[n];
        for(int i=0;i <n;i++)
        {
            visited[i]=0;
            adj.add(new ArrayList<>());
        }
        int m=edges.length;
        for(int i=0;i<m;i++)
        {
            int a=edges[i][0];
            int b=edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
         c=n;
        long ans=0;
        for(int i=0;i<n;i++)
        {
            int x=c;
            if(visited[i]==0)
            {
                helper(adj,visited,i);
                ans+=(long)(x - c) * c;
            }
            
        }
        return ans;
        
        
    }
}