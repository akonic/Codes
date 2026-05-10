class Solution {
    private int helper(int[] nums, int target, int sum, int i, int[][] dp, int totalSum) {
        if (i == nums.length)
            return sum == target ? 1 : 0;
        if (Math.abs(sum) > totalSum)
            return 0;
        if (dp[i][totalSum + sum] != -1)
            return dp[i][totalSum + sum];

        return dp[i][totalSum + sum] = helper(nums, target, sum + nums[i], i + 1, dp, totalSum) +
                helper(nums, target, sum - nums[i], i + 1, dp, totalSum);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        int n = nums.length;
        for (int i : nums) {
            totalSum += i;
        }
        int[][] dp = new int[n + 1][2 * totalSum + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return helper(nums, target, 0, 0, dp, totalSum);
    }
}