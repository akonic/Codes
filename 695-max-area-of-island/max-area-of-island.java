class Solution {
    private boolean isValid(int x,int y,int n,int m)
    {
        if(x>=0 && x<n && y>=0 && y<m)
        {
            return true;
        }
        return false;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int[][] path = {{-1,0},{0,-1},{1,0},{0,1}};
        
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;

        int[][] visited = new int[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(visited[i],0);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(visited[i][j]==0 && grid[i][j]==1)
                {
                    Queue<int[]> q = new ArrayDeque<>();
                    int c=0;
                    q.offer(new int[]{i,j});
                    visited[i][j]=1;
                    c++;
                    while(!q.isEmpty())
                    {
                        int[] top = q.poll();
                        int x=top[0];
                        int y=top[1];
                        for(int[] dir : path)
                        {
                            int nx=x+dir[0];
                            int ny=y+dir[1];
                            if(isValid(nx,ny,n,m) && grid[nx][ny]==1 && visited[nx][ny]==0)
                            {
                                q.offer(new int[]{nx,ny});
                                visited[nx][ny]=1;
                                c++;
                            }
                        }
                    }
                    ans=Math.max(ans,c);
                }
            }
        }
        return ans;
    }
}