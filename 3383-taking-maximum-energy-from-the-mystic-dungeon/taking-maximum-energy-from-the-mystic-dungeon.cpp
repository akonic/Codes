class Solution {
public:
    int maximumEnergy(vector<int>& energy, int k) {
        int sum=INT_MIN,n=energy.size();
        vector<int> dp(n,0);
        for(int i=n-1;i>=0;i--)
        {
            if(i+k>=n)
            {
                dp[i]=energy[i];
            }
            else{
                dp[i]=energy[i]+dp[i+k];
            }
            sum=max(sum,dp[i]);
        }
        return sum;
    }
};