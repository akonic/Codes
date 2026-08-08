class Solution {
    private int helper(int[][] matrix,int i,int j,int[][] dp)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        if(i==n)
        {
            return 0;
        }
        if(j<0 || j>=m)
        {
            return 100000;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        return dp[i][j]= matrix[i][j]  + Math.min(helper(matrix,i+1,j,dp),Math.min(helper(matrix,i+1,j-1,dp),helper(matrix,i+1,j+1,dp)));
    }
    public int minFallingPathSum(int[][] matrix) {
        int ans=Integer.MAX_VALUE;
        int n = matrix.length;
        int[][] dp = new int[n][n];
            for(int[] j : dp)
            {
                Arrays.fill(j,-1);
            }
        for(int i=1;i<n;i++)
        {   
           for (int j=0;j<n;j++)
           {
                int p=matrix[i-1][j];
                if(j-1>=0)
                {
                    p=Math.min(p,matrix[i-1][j-1]);
                }
                if(j+1<n)
                {
                    p=Math.min(p,matrix[i-1][j+1]);
                }

                matrix[i][j]+=p;
           }
        }
        for(int i=0;i<n;i++)
        { 
            ans=Math.min(ans,matrix[n-1][i]);
        }
        return ans;
    }
}