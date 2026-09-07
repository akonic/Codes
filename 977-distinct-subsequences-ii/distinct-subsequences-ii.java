class Solution {
    int mod = 1000000007;

    private int helper(int n, int[] prev, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int total = (2 * helper(n - 1, prev, dp)) % mod;
        int duplicates = 0;
        if (prev[n] != 0) {
            duplicates = (helper(prev[n] - 1, prev, dp)) % mod;
        }

        dp[n] = (total - duplicates + mod) % mod;
        return dp[n];

    }

    public int distinctSubseqII(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[] prev = new int[n + 1];
        int[] lastSeen = new int[26];
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        for (int i = 1; i <= n; i++) {
            int c = ch[i - 1] - 'a';
            prev[i] = lastSeen[c];
            lastSeen[c] = i;
        }
       return (helper(n, prev, dp) - 1 + mod) % mod;
    }
}