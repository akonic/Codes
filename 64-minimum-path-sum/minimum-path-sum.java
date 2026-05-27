class Solution {
    private int helper(int[][] grid,int n,int m,int i,int j,int[][] dp)
    {
        if(i==n-1 && j==m-1)
        {
            return dp[i][j]=grid[i][j];
        }
        if(i>=n || j>=m)
        {
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int a=helper(grid,n,m,i+1,j,dp);
        int b=helper(grid,n,m,i,j+1,dp);
        if(a<Integer.MAX_VALUE)
        {
            a+=grid[i][j];
        }
        if(b<Integer.MAX_VALUE)
        {
            b+=grid[i][j];
        }
        return dp[i][j]=Math.min(a,b);
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }

        return helper(grid,n,m,0,0,dp);
    }
}