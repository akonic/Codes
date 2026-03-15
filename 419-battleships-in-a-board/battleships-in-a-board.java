class Solution {
    void helper(char[][] board,int[][] visited,int i,int j,int n,int m,int dir)
    {
        if(dir==1)
        {
            while(i+1<n && board[i+1][j]=='X')
            {
                visited[i+1][j]=1;
                i++;
            }
        }
        if(dir==0)
        {
            while(j+1<m && board[i][j+1]=='X')
            {
                visited[i][j+1]=1;
                j++;
            }
        }
    }
    public int countBattleships(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] visited = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                visited[i][j]=0;
            }
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='X' && visited[i][j]==0)
                {   visited[i][j]=1;
                    ans++;
                    if(i+1<n && board[i+1][j]=='X'){
                    helper(board,visited,i,j,n,m,1);
                    }
                    else if(j+1<m && board[i][j+1]=='X'){
                    helper(board,visited,i,j,n,m,0);
                    }
                }
            }
        }
        return ans;
    }
}