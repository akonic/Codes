class Solution {
public:
    int findSmallestInteger(vector<int>& nums, int value) {
         vector<int> cnt(value, 0);
        for (long long a : nums) {
            int r = (int)(((a % value) + value) % value); 
            cnt[r]++;
        }
        for (long long i = 0;; ++i) {
            int r = (int)(i % value);
            if (cnt[r] == 0) return (int)i;
            cnt[r]--; 
        }
    }
};