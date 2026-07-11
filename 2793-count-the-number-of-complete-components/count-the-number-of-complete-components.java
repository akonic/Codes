class Solution {
    private void dfs( List<List<Integer>> ls,int i, boolean[] visited,boolean[] check)
    {
        visited[i]=true;
        check[i]=true;
        for(int j : ls.get(i))
        {
            if(!visited[j])
            {
                dfs(ls,j,visited,check);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            ls.add(new ArrayList<>());
        }
        for(int[] edge : edges)
        {
            int a= edge[0];
            int b=edge[1];
            ls.get(a).add(b);
            ls.get(b).add(a);
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                boolean[] check = new boolean[n];
                Arrays.fill(check,false);
                dfs(ls,i,visited,check);
                boolean isComplete = true;
                int c=0;
                for(int j=0;j<n;j++)
                {
                    if(check[j])
                    {
                        c++;
                    }
                }
                c--;
                for(int j=0;j<n;j++)
                {
                    if(check[j] && ls.get(j).size()!=c)
                    {
                        isComplete=false;
                    }
                }
                if(isComplete)
                {
                    ans++;
                }
            }
        }
        return ans;

    }
}