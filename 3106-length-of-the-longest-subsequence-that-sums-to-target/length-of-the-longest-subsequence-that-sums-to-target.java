class Solution {
    private int helper(List<Integer> nums, int target,int i,int[][] dp)
    {
        if(target==0)
        {
            return 0;
        }
        if(target<0 || i>=nums.size())
        {
            return -1000;
        }
        if(dp[target][i]!=-1)
        {
            return dp[target][i];
        }
        return dp[target][i]=Math.max(1+helper(nums,target-nums.get(i),i+1,dp),helper(nums,target,i+1,dp));
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] dp = new int[target+1][n+1];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        int x =  helper(nums,target,0,dp);
        if(x<0)
        {
            return -1;
        } 
        return x;
    }
}