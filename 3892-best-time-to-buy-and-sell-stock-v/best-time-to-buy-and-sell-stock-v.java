class Solution {
    private long helper(int[] prices, int k, int i, int curr, int normal, int st,long[][][][] dp) {
        if (curr == 2 * k) {
            return 0;
        }
        if (i == prices.length) {
            if (curr % 2 == 0) {
                return 0;
            } else {
                return Integer.MIN_VALUE / 2;
            }
        }
        if(dp[i][curr][normal][st]!=-1)
        {
            return dp[i][curr][normal][st];
        }
        long a = Integer.MIN_VALUE;
        long b = helper(prices, k, i + 1, curr, normal, st,dp);
        if (st == 0 && normal == 0 && curr % 2 == 0) {
            long x = helper(prices, k, i + 1, curr + 1, 1, st,dp) - prices[i];
            long y = helper(prices, k, i + 1, curr + 1, normal, 1,dp) + prices[i];
            a = Math.max(x, y);
        }
        if (st == 1 && normal == 0 && curr % 2 == 1) {
            a = helper(prices, k, i + 1, curr + 1, normal, 0,dp) - prices[i];
        }
        if (normal == 1 && st == 0 && curr % 2 == 1) {
            a = helper(prices, k, i + 1, curr + 1, 0, st,dp) + prices[i];

        }

        return dp[i][curr][normal][st] = Math.max(a, b);
    }

    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[][][][] dp = new long[n][2 * k][2][2];
        for (long[][][] a : dp)
            for (long[][] b : a)
                for (long[] c : b)
                    Arrays.fill(c, -1);

        int st = 0, normal = 0, curr = 0, i = 0;
        return helper(prices, k, i, curr, normal, st,dp);
    }
}