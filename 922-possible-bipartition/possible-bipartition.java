class Solution {
    private boolean check(ArrayList<ArrayList<Integer>> adj, int[] color,int node)
    {
        for(int i : adj.get(node))
        {
            if(color[i]==-1)
            {
                color[i]=1-color[node];
                if(check(adj,color,i))
                {
                    return true;
                }
            }
            else if(color[i]==color[node])
            {
                return true;
            }
        }
        return false;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<dislikes.length;i++)
        {
            int a=dislikes[i][0]-1;
            int b=dislikes[i][1]-1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++)
        {
            if(color[i]==-1)
            {
                color[i]=1;
                if(check(adj,color,i))
                {
                    return false;
                }
            }
        }
        return true;
    }
}