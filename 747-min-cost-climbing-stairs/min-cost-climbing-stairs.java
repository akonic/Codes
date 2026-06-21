class Solution {
    private int helper(int[] cost, int i, int[] dp)
    {
        if(i >= cost.length)
        {
            return 0;
        }
        if(dp[i] != -1)
        {
            return dp[i];
        }
        int a = helper(cost, i+1, dp);
        int b = helper(cost, i+2, dp);
        int p = Math.min(a, b);
        return dp[i] = cost[i] + p;
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(helper(cost, 0, dp), helper(cost, 1, dp));
    }
}