class Solution {
public:
    int dp[3][1001];
    int fun(int e,int f)
    {
        if(f==0 || f==1)
        {
            return f;
        }
        if(e==1)
        {
            return f;
        }
        if(dp[e][f]!=-1)
        {
            return dp[e][f];
        }
        int ans=INT_MAX;
        for(int k=1;k<=f;k++)
        {
            int temp=1+max(fun(e-1,k-1),fun(e,f-k));
            ans=min(ans,temp);
        }
        return dp[e][f]=ans;
    }
       
    int twoEggDrop(int n) {
         memset(dp,-1,sizeof(dp));
        return fun(2,n);
    }
};