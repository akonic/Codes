class Solution {
    public int longestBalanced(int[] nums) {

        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            Set<Integer> vis = new HashSet<>();
            int even = 0, odd = 0;

            for (int j = i; j < n; j++) {
                if (vis.add(nums[j])) {
                    if ((nums[j] & 1) == 0)
                        even++;
                    else
                        odd++;
                }

                if (even == odd)
                    ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}