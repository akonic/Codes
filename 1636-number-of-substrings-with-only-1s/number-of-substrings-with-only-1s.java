class Solution {
    public int numSub(String s) {
        final int mod = 1_000_000_007;
        final long inv2 = (mod + 1) / 2;
        long ans = 0;
        int c = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                c++;
            } else if (c > 0) {
                ans = (ans + (long) c * (c + 1) % mod * inv2) % mod;
                c = 0;
            }
        }
        if (c > 0) {
            ans = (ans + (long) c * (c + 1) % mod * inv2) % mod;
        }
        return (int) ans;
    }
}