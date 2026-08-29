class Solution {
    private boolean isPalindrome(char[] ch, int i, int j, int[][] dp) {
        if (i >= j) {
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

    public int countSubstrings(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int ans = 0;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(ch, i, j, dp)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}