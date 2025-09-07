class Solution {
public:
int dp[501][501];
    int fun(vector<int>& nums1, vector<int>& nums2,int i,int j)
    {
        if(i>=nums1.size() || j>=nums2.size())
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int ans=0,a=fun(nums1,nums2,i+1,j+1),b=fun(nums1,nums2,i+1,j),c=fun(nums1,nums2,i,j+1);
        if(nums1[i]!=nums2[j])
        {
            ans=max({a,b,c});
        }
        else{
            ans=max({b,c,1+a});
        }
        return dp[i][j]=ans;
    }
    int maxUncrossedLines(vector<int>& nums1, vector<int>& nums2) {
        memset(dp,-1,sizeof(dp));
        return fun(nums1,nums2,0,0);
    }
};