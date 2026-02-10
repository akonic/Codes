class Solution {
    public long fun(int[] coins, int amount, int index,int[][] dp) {

        if (amount == 0) {
            return 0;
        }
        if (amount < 0 || index >= coins.length) {
            return Integer.MAX_VALUE;
        }
                if(dp[index][amount]!=-1)
        {
            return dp[index][amount];
        }
        long a=Integer.MAX_VALUE,b=Integer.MAX_VALUE;
        if(amount-coins[index]>=0)
        {
            a=1 + fun(coins, amount - coins[index],index,dp);
        }
        b=fun(coins, amount, index + 1,dp);
        return dp[index][amount]=(int)Math.min(a,b);
    }

    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] rows : dp)
        {
            Arrays.fill(rows,-1);
        }
        long a= fun(coins, amount, 0,dp);
        if(a>=Integer.MAX_VALUE)
        {
            return -1;
        }
 return (int)a;
    }
}