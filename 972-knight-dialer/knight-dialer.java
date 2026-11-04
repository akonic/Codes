class Solution {
    private static final int MOD = 1_000_000_007;

    private int dfs(int[][] pad, int x, int y, int n, int[][][] dp) {
        if (n == 0) {
            return 1;
        }
        if (dp[n][x][y] != -1) {
            return dp[n][x][y];
        }
        long sum = 0;
        if (x - 2 >= 0 && y + 1 < 3 && pad[x - 2][y + 1] != -1)
            sum += dfs(pad, x - 2, y + 1, n - 1, dp);
        if (x - 2 >= 0 && y - 1 >= 0 && pad[x - 2][y - 1] != -1)
            sum += dfs(pad, x - 2, y - 1, n - 1, dp);
        if (x - 1 >= 0 && y + 2 < 3 && pad[x - 1][y + 2] != -1)
            sum += dfs(pad, x - 1, y + 2, n - 1, dp);
        if (x + 1 < 4 && y + 2 < 3 && pad[x + 1][y + 2] != -1)
            sum += dfs(pad, x + 1, y + 2, n - 1, dp);
        if (x + 2 < 4 && y + 1 < 3 && pad[x + 2][y + 1] != -1)
            sum += dfs(pad, x + 2, y + 1, n - 1, dp);
        if (x + 2 < 4 && y - 1 >= 0 && pad[x + 2][y - 1] != -1)
            sum += dfs(pad, x + 2, y - 1, n - 1, dp);
        if (x - 1 >= 0 && y - 2 >= 0 && pad[x - 1][y - 2] != -1)
            sum += dfs(pad, x - 1, y - 2, n - 1, dp);
        if (x + 1 < 4 && y - 2 >= 0 && pad[x + 1][y - 2] != -1)
            sum += dfs(pad, x + 1, y - 2, n - 1, dp);

        return dp[n][x][y] = (int) (sum % MOD);
    }

    public int knightDialer(int n) {
        long ans = 0;
        int[][][] dp = new int[n][4][3];
        for (int[][] i : dp)
            for (int[] j : i)
                Arrays.fill(j, -1);

        int[][] pad = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
                { -1, 0, -1 }
        };

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                ans += dfs(pad, i, j, n - 1, dp);
        ans += dfs(pad, 3, 1, n - 1, dp);

        return (int) (ans % MOD);
    }
}