class Solution {
    public int checkPartition(int[] nums,int i,int W,int[][] dp)
    {
        if(W==0)
        {
            return 1; 
        }
        if(W<0 || i>=nums.length)
        {
            return 0;
        }
        if(dp[W][i]!=-1)
        {
            return dp[W][i];
        }
        int a=checkPartition(nums,i+1,W-nums[i],dp);
        int b=checkPartition(nums,i+1,W,dp);
        
        return  dp[W][i]= Math.max(a,b);
        
    }
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int W=0;
        for(int i : nums)
        {
            W+=i;
        }
        if(W%2!=0)
        {
            return false;
        }
        int[][] dp = new int[W/2 +1][n+1];
        for(int[] rows : dp)
        {
            Arrays.fill(rows,-1);
        }
        return checkPartition(nums, 0, W/2, dp) == 1;
    }
}