class Solution {
    private boolean check(char[] ch, int j, int len) {
        int i = j - len + 1;
        while (i < j) {
            if (ch[i] == ch[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        char[] bh = new char[n];
        for (int i = 0; i < n; i++) {
            bh[i] = ch[n - i - 1];
        }
        int[][] dp = new int[n + 1][n + 1];
        int ans = 0, x = -1, y = -1;
        int maxLen = 1;
        int end = 0;
        List<int[]> ls = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (ch[i - 1] == bh[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                int len = dp[i][j];
                int originalEnd = i - 1;

                if (len > maxLen && check(ch, originalEnd, len)) {
                    maxLen = len;
                    end = originalEnd;
                }
            }
        }

        return s.substring(end - maxLen + 1, end + 1);
    }
}