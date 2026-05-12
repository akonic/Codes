class Solution {
     private int ways(int[] coins,int amount,int n,int i,int[][] dp)
    {
        if(amount==0)
        {
            return 1;
        }
        if(i==n || amount<0)
        {
            return 0;
        }
        if(dp[amount][i]!=-1)
        {
            return dp[amount][i];
        }
        int a=0;
        if(amount-coins[i]>=0){
         a = ways(coins,amount-coins[i],n,i,dp);}
        int b= ways(coins,amount,n,i+1,dp);

        return dp[amount][i]=(a+b);
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[amount+1][n+1];
        for(int[] j : dp)
        {
            Arrays.fill(j,-1);
        }
        return ways(coins,amount,n,0,dp);
    }
}