class Solution {
    private int helper(int[] nums,int i,int target,int[][] dp)
    {
        if(target==0)
        {
            return 1;
        }
        if(dp[i][target]!=-1)
        {
            return dp[i][target];
        }
        int a = 0;
        for(int j=0;j<nums.length;j++)
        {
            int newTarget = target-nums[j];
            if(newTarget>=0)
            {
                a+=helper(nums,j,newTarget,dp);
            }
        }
        return dp[i][target]=a;
    }
    public int combinationSum4(int[] nums, int target) {
           Arrays.sort(nums);
        int n=nums.length;
        int[][] dp = new int[n+1][target+1];
        for(int[] i : dp){
        Arrays.fill(i,-1);}
      return helper(nums,0,target,dp);
    }
}