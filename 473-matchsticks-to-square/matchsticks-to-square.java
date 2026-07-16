class Solution {
    private boolean check(int[] nums, int i, int sum1, int sum2, int sum3, int sum4) {
        if (sum1 == 0 && sum2 == 0 && sum3 == 0 && sum4 == 0) {
            return true;
        }
        if (sum1 < 0 || sum2 < 0 || sum3 < 0 || sum4 < 0) {
            return false;
        }
        if (i >= nums.length) {
            return false;
        }

        sum1 -= nums[i];
        boolean check1 = check(nums, i + 1, sum1, sum2, sum3, sum4);
        sum1 += nums[i];
        if (check1) return true;

        if (sum2 != sum1) {
            sum2 -= nums[i];
            boolean check2 = check(nums, i + 1, sum1, sum2, sum3, sum4);
            sum2 += nums[i];
            if (check2) return true;
        }

        if (sum3 != sum2) {
            sum3 -= nums[i];
            boolean check3 = check(nums, i + 1, sum1, sum2, sum3, sum4);
            sum3 += nums[i];
            if (check3) return true;
        }

        if (sum4 != sum3) {
            sum4 -= nums[i];
            boolean check4 = check(nums, i + 1, sum1, sum2, sum3, sum4);
            sum4 += nums[i];
            if (check4) return true;
        }

        return false;
    }

    public boolean makesquare(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int max = 0;
        for (int i : nums) {
            sum += i;
            max = Math.max(max, i);
        }
        if (sum % 4 != 0) {
            return false;
        }
        int side = sum / 4;
        if (max > side) {
            return false;
        }

        Integer[] boxed = new Integer[n];
        for (int i = 0; i < n; i++) boxed[i] = nums[i];
        Arrays.sort(boxed, Collections.reverseOrder());
        for (int i = 0; i < n; i++) nums[i] = boxed[i];

        return check(nums, 0, side, side, side, side);
    }
}