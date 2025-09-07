class Solution {
public:
    int dp[301][301];
    int dfs(vector<int>& v,int l,int r)
    {
        if(l>r)
        {
            return 0;
        }
        if(dp[l][r]!=-1)
        {
            return dp[l][r];
        }
        int ans=0;
        for(int i=l;i<=r;i++)
        {
            int c=v[l-1]*v[i]*v[r+1];
            int x=dfs(v,l,i-1)+dfs(v,i+1,r);
            ans=max(ans,c+x);
        }
        return dp[l][r]=ans;
    }
    int maxCoins(vector<int>& nums) {
      int n=nums.size();
      memset(dp,-1,sizeof(dp));
        vector<int> v(n+2,1);
         for (int i = 0; i < n; i++) {
            v[i + 1] = nums[i];
        }
        return dfs(v,1,v.size()-2);
    }


};