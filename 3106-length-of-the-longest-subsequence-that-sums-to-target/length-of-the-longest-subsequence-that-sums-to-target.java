class Solution {
    private int helper(int[] nums, int target, int i, int[][] dp) {
        if (target == 0) return 0;
        if (target < 0 || i >= nums.length) return -1000;
        if (dp[target][i] != -1) return dp[target][i];

        int a = -1000;
        if (target - nums[i] >= 0) {
            a = 1 + helper(nums, target - nums[i], i + 1, dp);
        }
        int b = helper(nums, target, i + 1, dp);
        return dp[target][i] = Math.max(a, b);
    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = nums.get(i);

        int[][] dp = new int[target + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        int x = helper(arr, target, 0, dp);
        return x < 0 ? -1 : x;
    }
}