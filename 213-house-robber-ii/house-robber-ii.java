class Solution {
    private int helper(int[] nums, int prevPick, int i, int n,int[][] dp) {
        if (i == n) {
            return 0;
        }
        if(dp[i][prevPick]!=-1)
        {
            return dp[i][prevPick];
        }
        int pick = 0, notPick = 0;
        if (prevPick == 0) {
            pick = nums[i] + helper(nums, 1, i + 1, n,dp);
        }
        notPick = helper(nums, 0, i + 1, n,dp);

        return dp[i][prevPick]=Math.max(pick, notPick);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)
        {
            return nums[0];
        }
        int[][] dp1 = new int[n][2];
        int[][] dp2 = new int[n][2];
        for(int i=0;i<n;i++)
        {
            dp1[i][0]=-1;
            dp1[i][1]=-1;
            dp2[i][0]=-1;
            dp2[i][1]=-1;
        }
        int ans1=nums[0]+helper(nums,1,1,n-1,dp1);
        int ans2=helper(nums,0,1,n,dp2);
                return Math.max(ans1,ans2);
    }
}