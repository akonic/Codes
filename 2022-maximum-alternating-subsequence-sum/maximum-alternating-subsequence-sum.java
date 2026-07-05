class Solution {
    private long helper(int[] nums, int i, int last,long[][] dp)
    {
        if(i==nums.length)
        {
            return 0;
        }
        if(dp[i][last]!=-1)
        {
            return dp[i][last];
        }
        long pick=0,skip=0;
        if(last==0)
        {
            pick=nums[i]+helper(nums,i+1,1,dp);
            skip=helper(nums,i+1,0,dp);
        }
        else if(last==1)
        {
            pick=helper(nums,i+1,0,dp)-nums[i];
            skip=helper(nums,i+1,1,dp);
        }
        return dp[i][last]=Math.max(pick,skip);
        
    }
    public long maxAlternatingSum(int[] nums) {
        int n= nums.length;
        long[][] dp = new long[n][2];
        for(long[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(nums,0,0,dp);
    }
}