class Solution {
public:
    void dfs(vector<vector<int>>& adj,int i,vector<int>& visited)
    {
        visited[i]=1;
        for(auto& v : adj[i])
        {
            if(visited[v]==0)
            {
                dfs(adj,v,visited);
            }
        }
    }
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
       
        int n=rooms.size();
        vector<vector<int>> adj(n);
        for(int i=0;i<n;i++)
        {
            for(auto& j : rooms[i])
            {
                adj[i].push_back(j);
               // adj[j].push_back(i);
            }
        }
        vector<int> visited(n,0);
        dfs(adj,0,visited);

        for(auto& i : visited){
            if(i==0)
            {
                return false;
            }
        }
        return true;;
    }
};