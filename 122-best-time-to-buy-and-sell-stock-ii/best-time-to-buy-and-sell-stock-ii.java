class Solution {
    private int helper(int[] prices,int i,int hold,int[][] dp)
    {
        if(i==prices.length)
        {
            return 0;
        }
        int a=Integer.MIN_VALUE;
        int b=Integer.MIN_VALUE;
        int c=Integer.MIN_VALUE;
        if(dp[i][hold]!=-1)
        {
            return dp[i][hold];
        }
        if(hold==0)
        {
            a=helper(prices,i+1,1,dp) - prices[i];
        }
        else{
            b=helper(prices,i+1,0,dp)+prices[i];
        }
         c= helper(prices,i+1,hold,dp);
        return dp[i][hold] = Math.max(a,Math.max(b,c));
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp = new int[n][2];
        for(int i=0;i<n;i++)
        {
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        return helper(prices,0,0,dp);
    }
}