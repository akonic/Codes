class Solution {
    private boolean isPalindrome(char[] ch, int i, int j, int[][] dp) {
        if (i > j)
            return true;

        if (i == j) {
            dp[i][j] = 1;
            return true;
        }
        if (dp[i][j] != -1) {
            if (dp[i][j] == 1) {
                return true;
            }
            return false;
        }
        if (ch[i] == ch[j] && isPalindrome(ch, i + 1, j - 1, dp)) {

            dp[i][j] = 1;
            return true;
        }

        dp[i][j] = 0;
        return false;
    }

    public int minCut(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        int ans = 2001;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                boolean a = isPalindrome(ch, i, j, dp);
            }
        }
        int[] cut = new int[n + 1];
        cut[n] = -1;

        for (int i = n - 1; i >= 0; i--) {
            cut[i] = Integer.MAX_VALUE;

            for (int j = i; j < n; j++) {
                if (dp[i][j] == 1) {
                    cut[i] = Math.min(cut[i], 1 + cut[j + 1]);
                }
            }
        }

        return cut[0];
    }
}