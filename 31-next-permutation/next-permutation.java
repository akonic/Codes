class Solution {
    private boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean isSortedRev(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return;
        }
        if (isSortedRev(nums)) {
            Arrays.sort(nums);
            return;
        }
        if (isSorted(nums)) {
            int temp = nums[n - 1];
            nums[n - 1] = nums[n - 2];
            nums[n - 2] = temp;
            return;
        }
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int x = i;
                for (int j = n - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        x = j;
                        break;
                    }
                }
                int temp = nums[x];
                nums[x] = nums[i - 1];
                nums[i - 1] = temp;
                reverse(nums, i, n - 1);
                return;
            }
        }

    }
}