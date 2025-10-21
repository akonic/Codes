class Solution {
public:
    void dfs(vector<vector<int>>& adj,vector<bool>& visited,int i,int& c)
    {
        c++;
        visited[i]=1;
        for(int j=0;j<adj[i].size();j++)
        {
            if(!visited[adj[i][j]])
            {
                dfs(adj,visited,adj[i][j],c);
            }
        }
    }
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        int n=rooms.size();
        vector<vector<int>> adj(n);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<rooms[i].size();j++)
            {
                adj[i].push_back(rooms[i][j]);
            }
        }
        vector<bool> visited(n,0);
        int c=0;
            dfs(adj,visited,0,c);
            if(c==n)
            {
                return true;
            }
        return false;
    }
};