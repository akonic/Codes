class Solution {
    private int helper(int[] cost,int i,int[] dp)
    {
        if(i==cost.length)
        {
            return 0;
        }
        if(i>cost.length)
        {
            return Integer.MAX_VALUE;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        int a=0,b=0;
        a=helper(cost,i+1,dp);
        b=helper(cost,i+2,dp);
        int p=Math.min(a,b);
        return dp[i]=cost[i] + p;
        
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        return Math.min(helper(cost,0,dp1),helper(cost,1,dp2));
    }
}