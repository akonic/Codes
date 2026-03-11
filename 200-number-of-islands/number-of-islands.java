class Solution {
    void dfs(char[][] grid,int i,int j,int[][] visited,int n,int m)
    {
        visited[i][j]=1;
        if(i+1<n && visited[i+1][j]==0 && grid[i+1][j]=='1')
        {
            dfs(grid,i+1,j,visited,n,m);
        }
        if(j+1<m && visited[i][j+1]==0 && grid[i][j+1]=='1')
        {
            dfs(grid,i,j+1,visited,n,m);
        }
        if(i-1>=0 && visited[i-1][j]==0 && grid[i-1][j]=='1')
        {
            dfs(grid,i-1,j,visited,n,m);
        }
        if(j-1>=0 && visited[i][j-1]==0 && grid[i][j-1]=='1')
        {
            dfs(grid,i,j-1,visited,n,m);
        }

    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                visited[i][j]=0;
            }
        }
        int c=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(visited[i][j]==0 && grid[i][j]=='1')
                {
                    c++;
                    dfs(grid,i,j,visited,n,m);
                }
            }
        }    
        return c;
    }
}