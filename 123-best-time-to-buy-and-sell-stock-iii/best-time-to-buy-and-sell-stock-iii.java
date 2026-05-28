class Solution {
    private int helper(int[] prices, int transaction, int i,int[][] dp) {
        if(i==prices.length || transaction ==4)
        {
            return 0;
        }
        if(dp[i][transaction]!=-1)
        {
            return dp[i][transaction];
        }
        int a= Integer.MIN_VALUE;
        int b= helper(prices,transaction,i+1,dp);
        if(transaction==0 || transaction == 2)
        {
            a=helper(prices,transaction+1,i+1,dp) - prices[i];
        }
        if(transaction==1 || transaction == 3)
        {
            a=helper(prices,transaction+1,i+1,dp) + prices[i];
        }
       return  dp[i][transaction] = Math.max(a,b);
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(prices,0,0,dp);
    }
}