class Solution {
public:
    int dp[10001];
    bool fun(vector<int>& nums,int i)
    {
        if(i>=nums.size()-1)
        {
            return true;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        bool ans=false;
        for(int j=1;j<=nums[i];j++)
        {
            ans= ans || fun(nums,i+j);
        }
        return dp[i]=ans;

    }
    bool canJump(vector<int>& nums) {

        int n=nums.size(),jump=nums[0];
        for(int i=1;i<n;i++)
        {
            if(jump<i)
            {
                return false;
            }
            jump=max(jump,i+nums[i]);
        }
        return true;
    }
};