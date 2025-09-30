class Solution {
public:
    vector<int> fun(vector<int>& nums)
    {
        if (nums.size()==1)
        {
            return nums;
        }
        vector<int> v;
        for(int i=1;i<nums.size();i++)
        {
            v.push_back((nums[i]+nums[i-1])%10);
        }
        return v;
    }
    int triangularSum(vector<int>& nums) {
        while(nums.size()>1)
        {
            nums=fun(nums);
        }
        return nums[0];
    }
};