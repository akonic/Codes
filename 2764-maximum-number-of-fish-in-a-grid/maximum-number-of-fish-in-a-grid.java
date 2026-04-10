class Solution {
    public int findMaxFish(int[][] grid) {
        int[][] path = {{-1,0},{0,-1},{1,0},{0,1}};
        
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]!=0)
                {
                    Queue<int[]> q = new ArrayDeque<>();
                    int c=0;
                    q.offer(new int[]{i,j});
                    c+=grid[i][j];
                    grid[i][j]=0;
                    
                    while(!q.isEmpty())
                    {
                        int[] top = q.poll();
                        int x=top[0];
                        int y=top[1];
                        for(int[] dir : path)
                        {
                            int nx=x+dir[0];
                            int ny=y+dir[1];
                            if((nx>=0 && ny>=0 && nx<n && ny<m) && grid[nx][ny]!=0 )
                            {
                                q.offer(new int[]{nx,ny});
                                c+=grid[nx][ny];
                                grid[nx][ny]=0;
                                
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