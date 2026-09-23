class Solution {
    private int bSearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1; // target not found
    }

    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suff = new int[n];
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            pre[i] = sum;
            if (sum == x) {
                ans = Math.min(ans, i + 1);
            }
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            suff[i] = sum;
            if (sum == x) {
                ans = Math.min(ans, n - i);
            }
        }

        for (int k = n - 1; k >= 0; k--) {
            if (suff[k] == x) {
                ans = Math.min(ans, n - k);
                continue;
            }

            int p = bSearch(pre, 0, k - 1, x - suff[k]);
            if (p != -1) {
                ans = Math.min(ans, (p + 1) + (n - k));
            }
        }
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;

    }
}