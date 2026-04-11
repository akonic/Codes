class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] visited = new int[n][m];
        int[][] ans = new int[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(visited[i],0);
             Arrays.fill(ans[i],0);
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               if(mat[i][j]==0)
               {
                    q.offer(i*m + j);
                    visited[i][j]=1;
               }
            }
        }
        while(!q.isEmpty())
        {
            int top=q.poll();
            int x=top/m;
            int y=top%m;
            for(int[] dir : dirs)
            {
                int nx=x+dir[0];
                int ny=y+dir[1];

                if(nx>=0 && nx<n && ny>=0 && ny<m && visited[nx][ny]==0)
                {
                    q.offer(nx*m + ny);
                    visited[nx][ny]=1;
                    ans[nx][ny]=ans[x][y]+1;
                }
            }
        }
        return ans;

    }
}