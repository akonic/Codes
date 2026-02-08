class Solution {
    public int fun(int[] nums,int i,int target,int x,int sum,int[][] dp)
    {
        if (i == nums.length) {
            return x == target ? 1 : 0;
        }
        if(dp[sum+x][i]!=-1)
        {
            return dp[sum+x][i];
        }
        return dp[sum+x][i]=fun(nums,i+1,target,x-nums[i],sum,dp) + fun(nums,i+1,target,x+nums[i],sum,dp);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n =nums.length;
        int sum=0;
        for(int i : nums)
        {
            sum+=i;
        }
        int[][] dp = new int[2*sum+1][n];
        for(int[] rows : dp)
        {
            Arrays.fill(rows,-1);
        }
        return fun(nums,0,target,0,sum,dp);
    }
}