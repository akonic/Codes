class Solution {
    // public int helper(int[][] mat,int i,int j,int[][] dp)
    // {
    //     if(i==mat.length-1)
    //     {
    //         return mat[i][j];
    //     }
    //     if(j>=mat[i].length)
    //     {
    //         return Integer.MAX_VALUE;
    //     }
    //     if(dp[i][j]!=-1)
    //     {
    //         return dp[i][j];
    //     }
    //     int a= helper(mat,i+1,j+1,dp);
    //     int b=helper(mat,i+1,j,dp);

    //     return dp[i][j]= mat[i][j] + Math.min(a,b);
        
    // }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        dp[0][0]=triangle.get(0).get(0);
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                int a=Integer.MAX_VALUE;
                int b=Integer.MAX_VALUE;
                if(j<i) a= dp[i-1][j];
                if(j-1>=0)
                {
                    b=dp[i-1][j-1];
                }
                dp[i][j]=triangle.get(i).get(j) + Math.min(a,b);
            }
        }
        int x=Integer.MAX_VALUE;
        for(int i : dp[n-1])
        {
            x=Math.min(x,i);
        }
        return x;
    }
}