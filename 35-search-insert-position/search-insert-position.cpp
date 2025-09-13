class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int n = nums.size();
        int i = 0, j = n;
        while (i <j) {
            int mid = i + (j - i) / 2;
            if (target<=nums[mid]) {
                
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        if (i < n && nums[i] < target) {
            i++;
        }
        return i;
    }

};