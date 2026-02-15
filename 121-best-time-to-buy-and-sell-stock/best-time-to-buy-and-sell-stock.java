class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int p=prices[0];
        for(int i=1;i<prices.length;i++)
        {
            ans=Math.max(ans,prices[i]-p);
            p=Math.min(p,prices[i]);
        }
        return ans;
    }
}