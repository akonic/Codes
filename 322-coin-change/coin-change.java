class Solution {
    private long helper(int[] coins,int amount,int i,long[][] dp)
    {
        if(amount == 0)
        {
            return 0;
        }
        if(i>=coins.length || amount<0)
        {
            return Integer.MAX_VALUE;
        }
        if(dp[i][amount]!=-1)
        {
            return dp[i][amount];
        }
        return dp[i][amount]=Math.min(1+helper(coins,amount-coins[i],i,dp),helper(coins,amount,i+1,dp));
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        long[][] dp = new long[n+1][amount+1];
        for(long[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        long p=helper(coins,amount,0,dp);
        if(p==Integer.MAX_VALUE)
        {
            return -1;
        }
        
        return (int)p;
    }
}