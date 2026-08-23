class Solution {

    private int helper(int[] prices, int fee, int i, int flag, int[][] dp) {
        if (i == prices.length) {
            return 0;
        }

        if (dp[i][flag] != -1) {
            return dp[i][flag];
        }

        int skip = helper(prices, fee, i + 1, flag, dp);
        int pick;

        if (flag == 0) {
            pick = helper(prices, fee, i + 1, 1, dp) - prices[i];
        } else {
            pick = prices[i] - fee + helper(prices, fee, i + 1, 0, dp);
        }

        return dp[i][flag] = Math.max(pick, skip);
    }

    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(prices, fee, 0, 0, dp);
    }
}