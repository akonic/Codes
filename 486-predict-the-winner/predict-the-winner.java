class Solution {
    private int helper(int[] nums,int i,int j,int[][] dp)
    {
        if(i>j)
        {
            return 0;
        }
        if(i==j)
        {
            return nums[i];
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int take_i = nums[i]+Math.min(helper(nums,i+2,j,dp),helper(nums,i+1,j-1,dp));
        int take_j = nums[j]+Math.min(helper(nums,i+1,j-1,dp),helper(nums,i,j-2,dp));

        return dp[i][j]=Math.max(take_i,take_j);
    }
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i:nums)
        {
            sum+=i;
        }
        int[][] dp = new int[n][n];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        int score = helper(nums,0,n-1,dp);
        if(score>=sum-score)
        {
            return true;
        }
        return false;
    }
}