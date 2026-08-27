class Solution {
    int mod = 1000000007;

    private int helper(int n, int m, int i, int j, int maxMove, int[][][] dp) {
        if (i == -1 || i == n || j == -1 || j == m) {
            return 1;
        }
        if (maxMove == 0) {
            return 0;
        }
        if (dp[i][j][maxMove] != -1) {
            return dp[i][j][maxMove];
        }
        int a = helper(n, m, i + 1, j, maxMove - 1, dp) % mod;
        int b = helper(n, m, i, j + 1, maxMove - 1, dp) % mod;
        int c = helper(n, m, i - 1, j, maxMove - 1, dp) % mod;
        int d = helper(n, m, i, j - 1, maxMove - 1, dp) % mod;
        return dp[i][j][maxMove] = (((a + b) % mod + c) % mod + d) % mod;
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m + 1][n + 1][maxMove + 1];
        for (int[][] i : dp) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }
        return helper(m, n, startRow, startColumn, maxMove, dp);
    }
}