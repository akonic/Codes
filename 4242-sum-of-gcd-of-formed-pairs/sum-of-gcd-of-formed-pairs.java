class Solution {
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] preGcd = new int[n];
        int x = nums[0];

        for (int i = 0; i < n; i++) {
            if (nums[i] > x)
                x = nums[i];
            preGcd[i] = gcd(x, nums[i]);
        }

        Arrays.sort(preGcd);

        long ans = 0;
        for (int i = 0; i < n / 2; i++) {
            ans += gcd(preGcd[i], preGcd[n - i - 1]);
        }
        return ans;
    }
}