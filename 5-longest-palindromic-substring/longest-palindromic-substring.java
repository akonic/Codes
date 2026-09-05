class Solution {

    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int maxL = 1, ind = 0;

        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++)
            dp[i][i] = true;

        for (int L = 2; L <= n; L++) {
            if (L <= maxL)
                continue;

            for (int i = 0; i <= n - L; i++) {
                int j = i + L - 1;

                if (ch[i] == ch[j] && (L == 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    maxL = L;
                    ind = i;
                }
            }
        }

        return s.substring(ind, ind + maxL);
    }
}