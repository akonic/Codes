class Solution {

    private int[] helper(int[] nums, int i, int j, int[][][] dp) {
        if (i > nums.length || j > nums.length) {
            return new int[] { 0, 1 };
        }
        if (dp[i][j][0] != -1) {
            return dp[i][j];
        }
        int[] pick = new int[] { 0, 0 };
        int[] skip = helper(nums, i + 1, j, dp);

        if (j == 0 || nums[j - 1] < nums[i - 1]) {
            pick = helper(nums, i + 1, i, dp);
            pick = new int[] { pick[0] + 1, pick[1] };
        }

        if (pick[0] > skip[0]) {
            return dp[i][j] = pick;
        }
        if (pick[0] < skip[0]) {
            return dp[i][j] = skip;
        }
        return dp[i][j] = new int[] { pick[0], pick[1] + skip[1] };
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);

        int max = 1;
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }

            if (dp[i] > max) {
                max = dp[i];
                result = cnt[i];
            } else if (dp[i] == max) {
                result += cnt[i];
            }
        }

        return result;
    }
}