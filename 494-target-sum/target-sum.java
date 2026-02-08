class Solution {
    public int fun(int[] nums,int i,int target,int x,int sum,int[][] dp)
    {
        if (i == nums.length) {
            return x == target ? 1 : 0;
        }
        if (dp[i][sum + x] != -1) {
            return dp[i][sum + x];
        }
        return dp[i][sum + x]=fun(nums,i+1,target,x-nums[i],sum,dp) + fun(nums,i+1,target,x+nums[i],sum,dp);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n =nums.length;
        int sum=0;
        for(int i : nums)
        {
            sum+=i;
        }
       int[][] dp = new int[n][2 * sum + 1];
        for(int[] rows : dp)
        {
            Arrays.fill(rows,-1);
        }
        return fun(nums,0,target,0,sum,dp);
    }
}