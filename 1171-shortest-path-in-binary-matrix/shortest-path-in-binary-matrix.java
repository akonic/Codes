class Solution {
    boolean isValid(int i, int j, int n,int[][] grid,int[][] visited) {
        if (i < n && j < n && i >= 0 && j >= 0 && grid[i][j] == 0 && visited[i][j] == 0) {
            return true;
        }
        return false;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1)
        {
            return -1;
        }
        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = 0;
            }
        }
        int res=Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        visited[0][0]=1;
        pq.offer(new int[]{1,0,0});
        while(!pq.isEmpty())
        {
            int[] a = pq.poll();
            int i=a[1];
            int j=a[2];
            int dist=a[0];
            if(isValid(i+1,j+1,n,grid,visited))
            {
                pq.offer(new int[]{dist+1,i+1,j+1});
                visited[i+1][j+1]=1;
            }
            if(i==n-1 && j==n-1 && grid[i][j]==0)
            {
                return dist;
            }
            if(isValid(i+1,j,n,grid,visited))
            {
                pq.offer(new int[]{dist+1,i+1,j});
                visited[i+1][j]=1;
            }
            
            if(isValid(i+1,j-1,n,grid,visited))
            {
                pq.offer(new int[]{dist+1,i+1,j-1});
                visited[i+1][j-1]=1;
            }            
            if(isValid(i,j+1,n,grid,visited))
            {
                pq.offer(new int[]{dist+1,i,j+1});
                visited[i][j+1]=1;
            }            
            if(isValid(i,j-1,n,grid,visited))
            {
                pq.offer(new int[]{dist+1,i,j-1});
                visited[i][j-1]=1;
            }            
            if(isValid(i-1,j,n,grid,visited))
            {
                pq.offer(new int[]{dist+1,i-1,j});
                visited[i-1][j]=1;
            }            
            if(isValid(i-1,j+1,n,grid,visited))
            {
                pq.offer(new int[]{dist+1,i-1,j+1});
                visited[i-1][j+1]=1;
            }
             if(isValid(i-1,j-1,n,grid,visited))
            {
                pq.offer(new int[]{dist+1,i-1,j-1});
                visited[i-1][j-1]=1;
            }
            
        }

        
        return  -1 ;
    }
}