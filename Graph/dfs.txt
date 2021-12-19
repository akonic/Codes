class Solution {
  void dfs1(int i,vector<int> &vis,vector<int> adj[],vector<int> &dfs)
    {
        dfs.push_back(i);
        vis[i]=1;
        for(auto p: adj[i])
        {
            if(!vis[p])
            {
                dfs1(p,vis,adj,dfs);
            }
        }
    }
  public:
    // Function to return a list containing the DFS traversal of the graph.
   
    vector<int> dfsOfGraph(int V, vector<int> adj[]) {
        // Code here
        vector<int> dfs,vis(V+1,0);
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                dfs1(i,vis,adj,dfs);
            }
        }
        return dfs;
    }
};
