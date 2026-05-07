class Solution {
    int as;
    private int helper(int[][] ls, int i, int n, int m,short[][][] dp) {
        if(i>=ls.length)
        {
            return 0;
        }
        if(dp[i][n][m]!=0)
        {
            return dp[i][n][m];
        }
        int a=0,b=0;
        if (n - ls[i][0] >= 0 && m - ls[i][1] >= 0) {
           a= 1+helper(ls, i + 1, n - ls[i][0], m - ls[i][1],dp);
        }
        b=helper(ls, i + 1, n, m,dp);
        return dp[i][n][m]=(short)Math.max(a,b);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] ls = new int[len][2];
        for (int i = 0; i < len; i++) {
            char[] pp = strs[i].toCharArray();
            int newLen = pp.length;
            int a = 0, b = 0;
            for (int j = 0; j < newLen; j++) {
                if (pp[j] == '1') {
                    a++;
                } else {
                    b++;
                }
            }
            ls[i][0] = a;
            ls[i][1] = b;
        }
       short[][][] dp = new short[len][n + 1][m + 1];
       return helper(ls, 0, n, m,dp);
       // return as;
    }
}