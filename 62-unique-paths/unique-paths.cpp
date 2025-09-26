class Solution {
public:
    int dp[101][101];
    int fun(int i,int j,int n,int m)
    {
        if(i==n-1 && j==m-1)
        {
            return 1;
        }
        if(i>=n || j>=m || i<0 || j<0)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int c=0;
        if(i+1<n)
        {
            c+=fun(i+1,j,n,m);
        }
        if(j+1<m)
        {
            c+=fun(i,j+1,n,m);
        }
        return dp[i][j]=c;
    }
    int uniquePaths(int n, int m) {
        memset(dp,-1,sizeof(dp));
        return fun(0,0,n,m);
    }
};