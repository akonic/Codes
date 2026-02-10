class Solution {
    public long fun(int n,int i,int[][] dp)
    {
        if(n==0)
        {
            return 0;
        }
        if(i>100)
        {
            return Integer.MAX_VALUE;
        }
        if(dp[n][i]!=-1)
        {
            return (long)dp[n][i];
        }
        long a=Integer.MAX_VALUE,b=Integer.MAX_VALUE;
        if(n-(i*i)>=0)
        {
            a=1+fun(n-(i*i),i,dp);
        }
        b=fun(n,i+1,dp);
        long x=Math.min(a,b);
        dp[n][i]=(int)x;
        return x;
    }
    public int numSquares(int n) {
        int[][] dp = new int[n+1][101];
        for(int[] rows : dp)
        {
            Arrays.fill(rows,-1);
        }
        return (int)fun(n,1,dp);
    }
}