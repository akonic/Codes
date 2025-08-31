class Solution {
public:
    int n,m;
    void dfs(vector<vector<char>>& grid,vector<vector<int>>& visited,int i,int j)
    {
        if(i>=n || j >=m || i<0 || j<0)
        {
            return;
        }
        if(i+1< n && visited[i+1][j]==-1 && grid[i+1][j]=='1')
        {
            visited[i+1][j]=1;
            dfs(grid,visited,i+1,j);
        }
        if(j-1>=0 && visited[i][j-1]==-1 && grid[i][j-1]=='1')
        {
            visited[i][j-1]=1;
            dfs(grid,visited,i,j-1);
        }
        if(i-1>=0 && visited[i-1][j]==-1 && grid[i-1][j]=='1')
        {
            visited[i-1][j]=1;
            dfs(grid,visited,i-1,j);
        }
        if(j+1<m && visited[i][j+1]==-1 && grid[i][j+1]=='1')
        {
            visited[i][j+1]=1;
            dfs(grid,visited,i,j+1);
        }
    }
    int numIslands(vector<vector<char>>& grid) {
         n= grid.size(),m=grid[0].size();
         int c=0;
        vector<vector<int>> visited(n+1,vector<int>(m+1,-1));
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1' && visited[i][j]==-1)
                {   visited[i][j]=1;
                    c++;
                    dfs(grid,visited,i,j);
                }
            }
        }
        return c;
    }
};