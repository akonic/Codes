class Solution {
    private int helper(int[] prices,int fee,int i,int flag,int[][] dp)
    {
        if(i>=prices.length)
        {
            return 0;
        }
        if(dp[i][flag]!=-1)
        {
            return dp[i][flag];
        }
        int pick=0,skip=0;
        if(flag==0)
        {
            pick=helper(prices,fee,i+1,1,dp)-prices[i];
            skip=helper(prices,fee,i+1,flag,dp);
        }
        else if(flag==1)
        {
            pick=prices[i]-fee + helper(prices,fee,i+1,0,dp);
            skip=helper(prices,fee,i+1,flag,dp);
        }

        return dp[i][flag]=Math.max(pick,skip);
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] i : dp)
        {
            
                Arrays.fill(i,-1);
            
        }
        return helper(prices,fee,0,0,dp);
    }
}