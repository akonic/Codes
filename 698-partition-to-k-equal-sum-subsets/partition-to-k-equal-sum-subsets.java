class Solution {
    int div;

    private void reverse(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    private boolean check(int[] arr) {
        for (int i : arr) {
            if (i != div) {
                return false;
            }
        }
        return true;
    }

    private boolean helper(int[] nums, int[] arr, int k, int i) {
        if (i == nums.length) {
            if (check(arr)) {
                return true;
            }
            return false;
        }
        boolean ans = false;

        for (int j = 0; j < k; j++) {
            if (arr[j] + nums[i] > div)
                continue;

            if (j > 0 && arr[j] == arr[j - 1])
                continue;

            arr[j] += nums[i];

            if (helper(nums, arr, k, i + 1))
                return true;

            arr[j] -= nums[i];

            if (arr[j] == 0)
                break;
        }
        return ans;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0) {
            return false;
        }

        div = sum / k;
        for (int i : nums) {
            if (i > div) {
                return false;
            }
        }
        Arrays.sort(nums);
        reverse(nums);
        int[] arr = new int[k];
        return helper(nums, arr, k, 0);
    }
}