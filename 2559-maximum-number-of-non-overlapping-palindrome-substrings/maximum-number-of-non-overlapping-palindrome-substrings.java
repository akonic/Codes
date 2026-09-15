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
        List<int[]> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j - i + 1 >= k && dp[i][j]) {
                    ls.add(new int[] { i, j });
                }
            }
        }
        ls.sort((a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int lastEnd = -1;

        for (int[] interval : ls) {
            if (interval[0] > lastEnd) {
                count++;
                lastEnd = interval[1];
            }
        }

        return count;

    }
}