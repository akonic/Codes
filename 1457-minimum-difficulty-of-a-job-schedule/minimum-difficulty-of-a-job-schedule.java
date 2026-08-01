class Solution {
    private int findMax(int[] nums, int i, int j) {
        int ans = -1;
        for (int k = i; k <= j; k++) {
            ans = Math.max(ans, nums[k]);
        }
        return ans;
    }

    private int helper(int[] nums, int prev, int d, int i,int[][][] dp) {

        if (d == 1) {
            int maxNum = findMax(nums, prev, nums.length - 1);
            return maxNum;
        }
        if(dp[prev][d][i]!=-1)
        {
            return dp[prev][d][i];
        }
        int make = Integer.MAX_VALUE;
        int skip = Integer.MAX_VALUE;

        int maxNum = findMax(nums, prev, i);
        if (i + 1 < nums.length) {
            make = helper(nums, i + 1, d - 1, i + 1,dp);
            skip = helper(nums, prev, d, i + 1,dp);
        }
        if(make!=Integer.MAX_VALUE)
        {
            make+=maxNum;
        }

        return dp[prev][d][i] = Math.min(make, skip);
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }
        int[][][] dp = new int[n+1][d+1][n+1];
        for(int[][] i :dp)
        {
            for(int[] j : i)
            {
                Arrays.fill(j,-1);
            }
        }
        return helper(jobDifficulty, 0, d, 0,dp);
    }
}