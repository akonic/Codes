class Solution {
    public int maxProfit(int[] prices) {
        int x=prices[0];
        int profit=0;
        for(int i : prices)
        {
            profit=Math.max(profit,i-x);
            if(i<x)
            {
                x=i;
            }
        }
        return profit;
    }
}