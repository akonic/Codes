class Solution {
    int ans;

    // int dfs(int[][] grid, int i, int j, int n, int m) {
    //     if(grid[i][j]==2)
    //     {
    //         return 0;
    //     }
    //     int a=Integer.MIN_VALUE;
    //     int b=Integer.MIN_VALUE;
    //     int c=Integer.MIN_VALUE;
    //     int d=Integer.MIN_VALUE;
    //     if (i + 1 < n && grid[i + 1][j] == 1) {
    //         grid[i + 1][j] = 2;
    //         a=1+dfs(grid, i + 1, j, n, m);
    //          grid[i+1][j]=1;
    //     }
    //     if (j + 1 < m && grid[i][j + 1] == 1) {
    //         grid[i][j+1] = 2;
    //        b=1+ dfs(grid, i, j + 1, n, m);
    //          grid[i][j+1]=1;
    //     }
    //     if (i - 1 >= 0 && grid[i - 1][j] == 1) {
    //         grid[i - 1][j] = 2;
    //         c=1+dfs(grid, i - 1, j, n, m);
    //          grid[i-1][j]=1;
    //     }
    //     if (j - 1 >= 0 && grid[i][j - 1] == 1) {
    //         grid[i][j-1] = 2;
    //        d=1+ dfs(grid, i, j - 1, n, m);
    //          grid[i][j-1]=1;
    //     }
    //    return Math.min(a, Math.min(b, Math.min(c, d)));

    // }
    private boolean isValid(int x,int y,int n,int m)
    {
        if(x>=0 && y>=0 && x<n && y<m)
        {
            return true;
        }
        return false;
    }
    public int orangesRotting(int[][] grid) {
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};
        while(!q.isEmpty())
        {
            boolean flag=false;
            int size=q.size();

            for(int i=0;i<size;i++)
            {
                int[] element=q.poll();
                int x=element[0];
                int y=element[1];

                for(int[] dir : dirs)
                {
                    int nx=x+dir[0];
                    int ny=y+dir[1];
                    if(isValid(nx,ny,n,m) && grid[nx][ny] == 1)
                    {
                        grid[nx][ny]=2;
                        q.offer(new int[]{nx,ny});
                        flag=true;
                    }
                }

            }
            if(flag==true)
            {
                ans++;
            }
        }
         for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                  return -1;
                }
            }
        }
        return ans;


    }
}