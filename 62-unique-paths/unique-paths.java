class Solution {
    private int helper(int n,int m,int i,int j,int[][] dp)
    {
        if(i==n-1 && j==m-1)
        {
            return 1;
        }
        if(i>=n || j>=m)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        return dp[i][j]=helper(n,m,i+1,j,dp) + helper(n,m,i,j+1,dp);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(m,n,0,0,dp);
    }
}