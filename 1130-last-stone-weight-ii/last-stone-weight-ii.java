class Solution {
    public int helper(int[] stones,int i,int target,int[][] dp,int total,int totalSum)
    {
        if(total>=target || i==stones.length)
        {
            return Math.abs(total-(totalSum-total));
        }
        if(dp[i][total]!=-1)
        {
            return dp[i][total];
        }

        return dp[i][total] = Math.min(helper(stones,i+1,target,dp,total+stones[i],totalSum),
        helper(stones,i+1,target,dp,total,totalSum));
    }
    public int lastStoneWeightII(int[] stones) {
        int totalSum=0;
        int n=stones.length;
        for(int i=0;i<n;i++)
        {
            totalSum+=stones[i];
        }
        int target=(totalSum+1)/2;
        int[][] dp = new int[n+1][target+1];
        for(int i=0;i<=n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(stones,0,target,dp,0,totalSum);
    }
}