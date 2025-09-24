class Solution {
public:
    long dp[10001];
    long fun(vector<int>& nums,int i)
    {
        if(i==nums.size()-1)
        {
            return 0;
        }
        if(i>=nums.size())
        {
            return INT_MAX;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        long taken=INT_MAX;
        if(nums[i]==0)
        {
            return INT_MAX;
        }
        for(int j=1;j<=nums[i];j++)
        {
            taken=min(taken,1+fun(nums,i+j));
        }
        return dp[i]=taken;
    }
    int jump(vector<int>& nums) {
        memset(dp,-1,sizeof(dp));
        return fun(nums,0);
    }
};