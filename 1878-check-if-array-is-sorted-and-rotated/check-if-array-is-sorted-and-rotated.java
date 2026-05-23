class Solution {
    public boolean check(int[] nums) {
         boolean check = false;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                if (check) return false;
                check = true;
            }
        }

        return true;
    }
}