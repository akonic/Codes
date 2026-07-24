class Solution {
    private int helper(int n, int i, int count, int[][][] dp) {
        if (n == 0)
            return count >= 2 ? 1 : 0;
        if (i > n)
            return 0;
        int c = Math.min(count, 2);
        if (dp[n][c][i] != -1)
            return dp[n][c][i];
        int pick = i * helper(n - i, i, count + 1, dp);
        int notPick = helper(n, i + 1, count, dp);
        return dp[n][c][i] = Math.max(pick, notPick);
    }

    public int integerBreak(int n) {
        int[][][] dp = new int[n + 1][3][n + 1];
        for (int[][] a : dp)
            for (int[] b : a)
                Arrays.fill(b, -1);
        return helper(n, 1, 0, dp);
    }
}