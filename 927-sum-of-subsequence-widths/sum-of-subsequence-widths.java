class Solution {
    public int sumSubseqWidths(int[] nums) {
        int n = nums.length;
        int MOD = 1_000_000_007;
        long[] pow = new long[n];
        long p = 1;
        for (int i = 0; i < n; i++) {
            pow[i] = p;
            p = (p * 2) % MOD;
        }
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long diff = (pow[i] - pow[n - i - 1]) % MOD;
            diff = (diff + MOD) % MOD;
            ans = (ans + (long) nums[i] * diff) % MOD;
        }
        return (int) ans;
    }
}