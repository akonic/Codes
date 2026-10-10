class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int max = 0;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }
        long[] cnt = new long[max + 1];
        for (int d : diff)
            cnt[d]++;

        long k = (long) k1 + k2;
        for (int d = max; d > 0 && k > 0; d--) {
            if (cnt[d] == 0)
                continue;
            long take = Math.min(k, cnt[d]);
            cnt[d] -= take;
            cnt[d - 1] += take;
            k -= take;
        }

        long ans = 0;
        for (int d = 1; d <= max; d++)
            ans += cnt[d] * d * d;
        return ans;
    }
}