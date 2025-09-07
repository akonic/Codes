class Solution {
public:
int dp[2501][2501];
    int fun(vector<int>& nums,int i,int prev)
    {
        if(i>=nums.size())
        {
            return 0;
        }
        if(dp[i][prev]!=-1)
        {
            return dp[i][prev];
        }
        int skip=0,take=0;
        skip=fun(nums,i+1,prev);
        if(nums[prev]<nums[i])
        {
            take=1+fun(nums,i+1,i);
        }
        return dp[i][prev]=max(skip,take);
    }
    int lengthOfLIS(vector<int>& nums) {
        nums.insert(nums.begin(),-10001);
        memset(dp,-1,sizeof(dp));
        return fun(nums,0,0);
    }
};