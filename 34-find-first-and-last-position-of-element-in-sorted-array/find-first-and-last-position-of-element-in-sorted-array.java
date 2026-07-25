class Solution {
    private int leftMost(int[] nums, int n, int target) {
        int leftMost = -1;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                r = mid - 1;
                leftMost = mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return leftMost;
    }

    private int rightMost(int[] nums, int n, int target) {
        int rightMost = -1;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                l = mid + 1;
                rightMost = mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return rightMost;
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        return new int[] { leftMost(nums, n, target), rightMost(nums, n, target) };
    }
}