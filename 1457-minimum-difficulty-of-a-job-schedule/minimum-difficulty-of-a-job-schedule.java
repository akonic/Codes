class Solution {
    private int findMax(int[] nums, int i, int j) {
        int ans = -1;
        for (int k = i; k <= j; k++) {
            ans = Math.max(ans, nums[k]);
        }
        return ans;
    }

    private int helper(int[] nums, int prev, int d, int[][] dp) {

        if (d == 1) {
            int maxNum = findMax(nums, prev, nums.length - 1);
            return maxNum;
        }
        if (dp[prev][d] != -1) {
            return dp[prev][d];
        }
        int ans=Integer.MAX_VALUE;
        for (int i = prev; i <=nums.length-d; i++) {
            int maxNum = findMax(nums, prev, i);
            ans = Math.min(ans,
                maxNum + helper(nums, i + 1, d - 1, dp));
        }
        return dp[prev][d] = ans;
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }
        int[][] dp = new int[n + 1][d + 1];
        for (int[] i : dp) {

            Arrays.fill(i, -1);

        }
        return helper(jobDifficulty, 0, d, dp);
    }
}