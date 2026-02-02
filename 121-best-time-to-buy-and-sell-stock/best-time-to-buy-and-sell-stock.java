class Solution {
    public int maxProfit(int[] prices) {
        int stock = prices[0];
        int ans=0;
        for(int i : prices)
        {
            ans=Math.max(ans,i-stock);
            if(i<stock)
            {
                stock=i;
            }
        }
        return ans;
    }
}