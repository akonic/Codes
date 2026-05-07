class Solution {
    private int check(int[] nums, int i, int sum, int[][] dp) {
        if (sum == 0) {
            return 1;
        }
        if (i >= nums.length || sum < 0) {
            return 0;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }
        dp[i][sum] = (check(nums, i + 1, sum - nums[i], dp) == 1 ||
                check(nums, i + 1, sum, dp) == 1) ? 1 : 0;
        return dp[i][sum];
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int[][] dp = new int[n + 1][sum / 2 + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
       
       return check(nums, 0, sum/2, dp) == 1;
    }
}