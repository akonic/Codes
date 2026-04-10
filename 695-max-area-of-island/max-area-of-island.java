class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] path = {{-1,0},{0,-1},{1,0},{0,1}};
        
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    Queue<int[]> q = new ArrayDeque<>();
                    int c=0;
                    q.offer(new int[]{i,j});
                    grid[i][j]=0;
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
                            if((nx>=0 && ny>=0 && nx<n && ny<m) && grid[nx][ny]==1 )
                            {
                                q.offer(new int[]{nx,ny});
                                grid[nx][ny]=0;
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