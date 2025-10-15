class Solution {
public:
    int maxIncreasingSubarrays(vector<int>& nums) {
       int ans = 1, x = 1, k = 0, n = nums.size();
        for (int i = 1; i < n; ++i) {
            if (nums[i] > nums[i - 1]) {
                ++x;
                if (k) ans = max(ans, min(k, x));
            } else {
                if (i + 1 < n && nums[i] < nums[i + 1]) {
                    k = x;
                    ans = max(ans, k / 2);
                    x = 1;
                } else {
                    k = 0;
                    x = 1;
                }
            }
            ans = max(ans, x / 2);
        }
        return ans;
    }
};