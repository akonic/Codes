class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int ans =0;
        int stock=prices[0];
        for(auto& i : prices)
        {
            ans=max(ans,i-stock);
            stock=min(i,stock);
        }
        return ans;
    }
};