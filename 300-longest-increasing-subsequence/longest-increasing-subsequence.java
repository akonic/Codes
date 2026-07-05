class Solution {
    private int helper(int[] nums,int i,int last,int[][] dp)
    {
        if(i==nums.length)
        {
            return 0;
        }
        if(dp[i][last]!=-1)
        {
            return dp[i][last];
        }
        int pick=0,skip=0;
        if(last==0)
        {
            pick=1+helper(nums,i+1,i+1,dp);
        }
        else if(nums[last-1]<nums[i])
        {
            pick=1+helper(nums,i+1,i+1,dp);
        }
        skip=helper(nums,i+1,last,dp);

         return dp[i][last]=Math.max(pick,skip);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(nums,0,0,dp);
    }
}