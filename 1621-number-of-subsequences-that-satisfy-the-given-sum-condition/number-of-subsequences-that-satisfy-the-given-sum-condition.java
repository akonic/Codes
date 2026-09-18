class Solution {
    public static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        int ans = 0;
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int[] powerOf2 = new int[n];
        powerOf2[0] = 1;
        for (int k = 1; k < n; k++) {
            powerOf2[k] = (powerOf2[k - 1] * 2) % MOD;
        }
        while (i <= j) {
            if (nums[i] + nums[j] <= target) {
                int len = j - i;
                ans = (ans + powerOf2[len]) % MOD;

                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}