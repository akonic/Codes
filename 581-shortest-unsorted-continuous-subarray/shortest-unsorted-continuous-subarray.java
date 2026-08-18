class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i - 1]);
            }
        }
        int l, r;
        for (l = 0; l < n; l++) {
            if (nums[l] > min) {
                break;
            }
        }
        for (r = n - 1; r >= 0; r--) {
            if (nums[r] < max) {
                break;
            }
        }
        if (r - l < 0) {
            return 0;
        }
        return r - l + 1;
    }
}