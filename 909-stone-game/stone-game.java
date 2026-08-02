class Solution {
    private int helper(int[] piles, int i, int j,int[][] dp) {
        if (i > j || i>=piles.length || j<0) {
            return 0;
        }
        if (i == j) {
            return piles[i];
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int left = piles[i] + Math.max(helper(piles, i + 2, j,dp), helper(piles, i + 1, j - 1,dp));
        int right = piles[j] + Math.max(helper(piles, i + 1, j - 1,dp), helper(piles, i, j - 2,dp));

        return dp[i][j] = Math.max(left, right);

    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int sum = 0;
        for (int i : piles) {
            sum += i;
        }
        int[][] dp = new int[n+1][n+1];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        int score = helper(piles, 0, n - 1,dp);

        if (score > sum - score) {
            return true;
        }
        return false;
    }
}