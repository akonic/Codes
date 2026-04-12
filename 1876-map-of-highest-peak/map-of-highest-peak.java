class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n=isWater.length;
        int m=isWater[0].length;
        int[][] ans = new int[n][m];
        int[][] visited = new int[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(visited[i],0);
            Arrays.fill(ans[i],0);
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(isWater[i][j]==1)
                {
                    q.offer(i*m + j);
                    visited[i][j]=1;
                }
            }
        }
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty())
        {
            int sz=q.size();
            for(int i=0;i<sz;i++)
            {
                int top=q.poll();
                int x=top/m;
                int y=top%m;
                for(int[] dir : dirs)
                {
                    int nx=x+dir[0];
                    int ny=y+dir[1];
                    if(nx>=0 && nx<n && ny>=0 && ny<m && visited[nx][ny]==0 && isWater[nx][ny]==0)
                    {
                        visited[nx][ny]=1;
                        ans[nx][ny]=ans[x][y]+1;
                        q.offer(nx*m + ny);
                    }
                }
            }
        }
        return ans;

    }
}