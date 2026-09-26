class Solution {
    public int longestBalanced(int[] nums) {

        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            Set<Integer> odds = new HashSet<>();
            Set<Integer> evens = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0) {
                    evens.add(nums[j]);
                }
                if (nums[j] % 2 == 1) {
                    odds.add(nums[j]);
                }
                if (evens.size() == odds.size()) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}