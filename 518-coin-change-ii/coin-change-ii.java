class Solution {
    public int fun(int[] coins, int amount, int index, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || index >= coins.length) {
            return 0;
        }
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }
        int a = 0, b = 0;

        a = fun(coins, amount - coins[index], index, dp);

        b = fun(coins, amount, index + 1, dp);

        return dp[index][amount] = a + b;

    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return fun(coins, amount, 0, dp);
    }
}