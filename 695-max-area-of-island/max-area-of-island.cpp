class Solution {
public:
    int n,m;
    int dfs(vector<vector<int>>& grid,vector<vector<int>>& visited,int i,int j)
    {
         if(i>=n || j >=m || i<0 || j<0)
        {
            return 0;
        }
        int a=0,b=0,c=0,d=0;
        if(i+1< n && visited[i+1][j]==-1 && grid[i+1][j]==1)
        {
            visited[i+1][j]=1;
            a=1+dfs(grid,visited,i+1,j);
        }
        if(j-1>=0 && visited[i][j-1]==-1 && grid[i][j-1]==1)
        {
            visited[i][j-1]=1;
             b=1+dfs(grid,visited,i,j-1);
        }
        if(i-1>=0 && visited[i-1][j]==-1 && grid[i-1][j]==1)
        {
            visited[i-1][j]=1;
             c=1+dfs(grid,visited,i-1,j);
        }
        if(j+1<m && visited[i][j+1]==-1 && grid[i][j+1]==1)
        {
            visited[i][j+1]=1;
             d=1+dfs(grid,visited,i,j+1);
        }
        return a+b+c+d;
    }
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        n=grid.size(),m=grid[0].size();
        int x=0;
        vector<vector<int>> visited(n+1,vector<int>(m+1,-1));
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(visited[i][j]==-1 && grid[i][j]==1)
                {
                    visited[i][j]=1;
                    x=max(x,1+dfs(grid,visited,i,j));
                }
            }
        }
        return x;
    }
};