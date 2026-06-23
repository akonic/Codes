class Solution {
    private int helper(int[] nums,int i,int pick,int[][] dp)
    {
        if(i>=nums.length)
        {
            return 0;
        }
        if(dp[i][pick]!=-1)
        {
            return dp[i][pick];
        }
        int a=0,b=0;
        a=helper(nums,i+1,1,dp);
        if(pick==1)
        {
            b=nums[i]+helper(nums,i+1,0,dp);
        }
        return dp[i][pick]=Math.max(a,b);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[][] dp = new int[nums.length][2];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        
        return helper(nums,0,1,dp);
    }
}