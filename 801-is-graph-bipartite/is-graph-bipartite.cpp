class Solution {
public:
    bool fun(vector<vector<int>>& graph,vector<int>& visited,int i,int color)
    {
        visited[i]=color;
        
        for(auto& j : graph[i])
        {
            if(visited[j]==visited[i])
            {
                return false;
            }
            if(visited[j]==-1)
            {
                if(fun(graph,visited,j,1-color)==false){
                return false;}
            }
        }
        return true;
    }
    bool isBipartite(vector<vector<int>>& graph) {
        int n=graph.size();
        vector<int> visited(n,-1);
        for(int i=0;i<n;i++)
        {
            if(visited[i]==-1)
            {
                if(!fun(graph,visited,i,1))
                {
                     return false;
                }   
            }
        }
        return true;
    }
};