class Solution {

    void dfs(char[][] board,int i,int j,int n,int m)
    {
        board[i][j]='P';
        if(i+1<n && board[i+1][j]=='O')
        {
            dfs(board,i+1,j,n,m);
        }
        if(j+1<m && board[i][j+1]=='O')
        {
            dfs(board,i,j+1,n,m);
        }
        if(i-1>=0 && board[i-1][j]=='O')
        {
            dfs(board,i-1,j,n,m);
        }
        if(j-1>=0 && board[i][j-1]=='O')
        {
            dfs(board,i,j-1,n,m);
        }
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='O' && (i==0 || j==0 || i==n-1 || j==m-1))
                {
                    dfs(board,i,j,n,m);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='P')
                {
                    board[i][j]='O';
                }
                else if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
            }
        }

    }
}