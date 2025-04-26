/* 0 - 1 Knapsack Problem

Given n items, each with a specific weight and value, and a knapsack with a capacity of W, the task is to put the items in the knapsack such that the sum of weights of the items <= W and the sum of values associated with them is maximized. 
Note: You can either place an item entirely in the bag or leave it out entirely. Also, each item is available in single quantity.

Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1] 
Output: 3
*/
class Solution {
  public:
   int dp[1001][1001];
    int memo(int capacity, vector<int> &val, vector<int> &wt,int n)
    {

        if (n <= 0)
        return 0;
        if (dp[n][capacity] != -1)
        {
            return dp[n][capacity];
        }
        if(wt[n-1]<=capacity)
        {
             dp[n][capacity] = max(val[n-1]+memo(capacity-wt[n-1],val,wt,n-1),memo(capacity,val,wt,n-1));
        }
        else if(wt[n-1] > capacity)
        {
           dp[n][capacity] = memo(capacity,val,wt,n-1);
        }
        return dp[n][capacity];
    }

    int knapsack(int W, vector<int> &val, vector<int> &wt) {

       int n=val.size();
       memset(dp,-1,sizeof(dp));
       return memo(W,val,wt,n);
        
    }
};
