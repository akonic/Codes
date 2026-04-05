class Solution {

    void dfs(char[][] board,int[][] visited,int i,int j,int n,int m)
    {
        visited[i][j]=1;
        if(i+1<n && board[i+1][j]=='O' && visited[i+1][j]!=1)
        {
            dfs(board,visited,i+1,j,n,m);
        }
        if(j+1<m && board[i][j+1]=='O' && visited[i][j+1]!=1)
        {
            dfs(board,visited,i,j+1,n,m);
        }
        if(i-1>=0 && board[i-1][j]=='O' && visited[i-1][j]!=1)
        {
            dfs(board,visited,i-1,j,n,m);
        }
        if(j-1>=0 && board[i][j-1]=='O' && visited[i][j-1]!=1)
        {
            dfs(board,visited,i,j-1,n,m);
        }
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] visited = new int[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(visited[i],0);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='O'&& visited[i][j]==0 && (i==0 || j==0 || i==n-1 || j==m-1))
                {
                    dfs(board,visited,i,j,n,m);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='O' && visited[i][j]!=1)
                {
                    board[i][j]='X';
                }
            }
        }

    }
}