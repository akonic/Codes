class Solution {
    private int helper(char[] ch, char[] bh, int i, int j, int n, int m, int[][] dp) {
        if (i == n || j == m) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (ch[i] == bh[j]) {
            return dp[i][j] = 1 + helper(ch, bh, i + 1, j + 1, n, m, dp);
        }

        return dp[i][j] = Math.max(helper(ch, bh, i + 1, j, n, m, dp), helper(ch, bh, i, j + 1, n, m, dp));
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        char[] ch = str1.toCharArray();
        char[] bh = str2.toCharArray();

        int n = ch.length;
        int m = bh.length;
        int[][] dp = new int[n][m];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        StringBuilder st = new StringBuilder();
        st.append(str1);
        st.append(str2);
        int p = helper(ch, bh, 0, 0, n, m, dp);
        int i = 0, j = 0;
        StringBuilder lcs = new StringBuilder();

        while (i < n && j < m) {
            if (ch[i] == bh[j]) {
                lcs.append(ch[i]);
                i++;
                j++;
            } else {
                int down = (i + 1 < n) ? dp[i + 1][j] : 0;
                int right = (j + 1 < m) ? dp[i][j + 1] : 0;

                if (down >= right)
                    i++;
                else
                    j++;
            }
        }
        i = 0;
        j = 0;
        StringBuilder ans = new StringBuilder();

        for (char c : lcs.toString().toCharArray()) {
            while (ch[i] != c)
                ans.append(ch[i++]);
            while (bh[j] != c)
                ans.append(bh[j++]);

            ans.append(c);
            i++;
            j++;
        }

        while (i < n)
            ans.append(ch[i++]);
        while (j < m)
            ans.append(bh[j++]);

        return ans.toString();

    }
}