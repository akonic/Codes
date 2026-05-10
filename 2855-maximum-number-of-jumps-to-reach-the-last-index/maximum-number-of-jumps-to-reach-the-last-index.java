class Solution {
    int cost;

    private void helper(int[] nums, int i, int target, int cs, int[] dp) {
        if (i == nums.length - 1) {
            dp[i] = Math.max(dp[i], cs);
            return;
        }
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] - nums[i] <= target && nums[j] - nums[i] >= -target && dp[j] == -1) {
                helper(nums, j, target, cs + 1, dp);
            }
        }

        return;

    }

    void dfs(int[] nums, int i, int[] dp,int target) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] - nums[i] <= target && nums[j] - nums[i] >= -target
                    && dp[j] < dp[i] + 1) {
                dp[j] = dp[i] + 1;
                dfs(nums, j, dp,target);
            }
        }
    }

    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;

        cost = Integer.MIN_VALUE;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        //helper(nums, 0, target,0,dp);
        dp[0] = 0;
        dfs(nums, 0,dp,target);
        return dp[n - 1];
    }
}