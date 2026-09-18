class Solution {
    public static final int MOD = 1_000_000_007;

    public static int powerModulo(int base, int exp) {
        int result = 1;

        base = (base % MOD + MOD) % MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (int) (((long) result * base) % MOD);
            }
            base = (int) (((long) base * base) % MOD);
            exp = exp >> 1;
        }
        return result;
    }

    public int numSubseq(int[] nums, int target) {
        int ans = 0;
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            if (nums[i] + nums[j] <= target) {
                int len = j - i;

                int contribution = powerModulo(2, len);

                ans = (ans + contribution) % MOD;

                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}