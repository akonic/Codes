class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int ans = 1;
        int i = 0, j = 1;
        mp.put(nums[i], 1);
        while (i <= j && j < n) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);

            while (mp.get(nums[j]) > k) {
                mp.put(nums[i], mp.getOrDefault(nums[i], 0) - 1);
                i++;
            }
            j++;

            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}