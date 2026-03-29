class Solution {
    // private void helper(ArrayList<ArrayList<Integer>> adj,int[] visited,int i)
    // {
    //     visited[i]=1;
    //     for(int j : adj.get(i))
    //     {
    //         if(visited[j]==0)
    //         {
    //             helper(adj,visited,j);
    //         }
    //     }
    // }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        int[] visited = new int[n];
        for(int i=0;i<n;i++)
        {
            visited[i]=0;
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isConnected[i][j]==1){
                adj.get(i).add(j);
                }
            }
        }
        int count =0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(visited[i]==0)
            {
                count++;
                q.offer(i);
                 visited[i]=1;
                while(!q.isEmpty())
                {
                    int p=q.peek();
                    q.poll();
                   
                    for(int j : adj.get(p))
                    {
                        if(visited[j]==0)
                        {
                             visited[j]=1;
                            q.offer(j);
                        }
                    }
                }
            }
        }
        
       
        return count;
    }
}