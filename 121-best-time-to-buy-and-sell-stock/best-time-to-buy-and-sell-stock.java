class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int x=Integer.MAX_VALUE,ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            x=Math.min(x,prices[i]);
            ans=Math.max(ans,prices[i]-x);
        }
        return ans;
    }
}