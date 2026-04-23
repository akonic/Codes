class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        mp.put(0, -1);

        for (int i = 0; i < n; i++) {
            sum += nums[i] == 0 ? -1 : 1;

            if (mp.containsKey(sum)) {
                ans = Math.max(ans, i - mp.get(sum));
            } else {
                mp.put(sum, i);
            }
        }
        return ans;
    }
}