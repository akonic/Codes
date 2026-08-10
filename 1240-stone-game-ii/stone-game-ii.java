class Solution {

    private int helper(int[] piles, int i, int M, int alice,int[][][] dp) {

        if (i >= piles.length) {
            return 0;
        }
        if(dp[i][M][alice]!=-1)
        {
            return dp[i][M][alice];
        }
        int ans = (alice == 1) ? 0 : Integer.MAX_VALUE;
        int temp = 0;

        for (int X = 1; X <= 2 * M && i + X <= piles.length; X++) {

            temp += piles[i + X - 1];

            if (alice == 1) {
                ans = Math.max(ans,
                        temp + helper(piles, i + X, Math.max(M, X), 0,dp));
            } else {
                ans = Math.min(ans,
                        helper(piles, i + X, Math.max(M, X), 1,dp));
            }
        }

        return dp[i][M][alice]=ans;
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][][] dp = new int[n+1][n+1][2];
        for(int[][] p : dp)
        {
            for(int[] i : p)
            {
                Arrays.fill(i,-1);
            }
        }
        return helper(piles, 0, 1, 1,dp);

    }
}