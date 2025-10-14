class Solution {
public:
    bool check(vector<int>& nums, int k,int ind)
    {
        for(int j=ind+1;j<ind+k;j++)
        {
            if(nums[j]<=nums[j-1])
            {
                return false;
            }
        }
        return true;
    }
    bool hasIncreasingSubarrays(vector<int>& nums, int k) {
        int n=nums.size();
        for(int i=0;i<n;i++)
        {
            if(i+k-1<n && check(nums,k,i) && i+k+k-1<n)
            {
                if(check(nums,k,i+k))
                {
                    return true;
                }
            }
        }
        return false;
    }
};