class Solution {
    public int maxPalindromes(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int L = 2; L <= n; L++) {
            for (int i = 0; i <= n - L; i++) {
                int j = i + L - 1;
                if (ch[i] == ch[j] && (L == 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        int[] f = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            f[i] = f[i + 1]; 

            for (int j = i + k - 1; j < n; j++) {
                if (dp[i][j]) {
                    f[i] = Math.max(f[i], 1 + f[j + 1]);
                }
            }
        }

        return f[0];

    }
}