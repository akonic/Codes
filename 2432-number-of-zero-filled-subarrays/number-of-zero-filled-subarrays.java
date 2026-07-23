class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0, c = 0;
        for (int i : nums) {
            if (i == 0) {
                c++;
            } else {
                if (c > 0) {
                    ans += (c) * (c + 1) / (long) 2;
                }
                c = 0;
            }
        }
        if (c > 0) {
            ans += (c) * (c + 1) / (long) 2;
        }
        c = 0;
        return ans;
    }
}