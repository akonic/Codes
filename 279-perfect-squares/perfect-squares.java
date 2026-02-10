class Solution {

    static final int INF = (int)1e9;

    public int fun(int n, int i, int[][] dp) {
        if (n == 0) return 0;

        if (i * i > n) return INF; 

        if (dp[n][i] != -1) {
            return dp[n][i];
        }

        int take = INF, skip;
        take = 1 + fun(n - i * i, i, dp);
        skip = fun(n, i + 1, dp);

        return dp[n][i] = Math.min(take, skip);
    }

    public int numSquares(int n) {
        int maxI = (int)Math.sqrt(n);
        int[][] dp = new int[n + 1][maxI + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return fun(n, 1, dp);
    }
}
