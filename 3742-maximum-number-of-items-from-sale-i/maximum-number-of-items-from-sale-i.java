class Solution {
    private int calculate(int[][] items, int k, int j) {
        int c = 0;
        for (int i = 0; i < items.length; i++) {
            if (i != j) {
                if (items[i][0] % k == 0) {
                    c++;
                }
            }
        }
        return c;
    }

    private int helper(int[][] arr, int i, int budget, int[][][] dp,int c) {
        if (i >= arr.length || budget==0) {
            return 0;
        }
        if (dp[i][budget][c] != -1) {
            return dp[i][budget][c];
        }
        int pick = 0, skip = 0;
        if (arr[i][0] <= budget) {
           int p=0;
           if(c==0)
           {
                p=arr[i][1];
           }
            pick = 1 + p + helper(arr, i, budget - arr[i][0], dp,1);
        }
        skip = helper(arr, i + 1, budget, dp,0);
        
        return dp[i][budget][c] = Math.max(pick, skip);
    }

    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = items[i][1];
            arr[i][1] = calculate(items, items[i][0], i);
        }
        int[][][] dp = new int[n][budget + 1][2];
        for(int[][] j : dp){
        for (int[] i : j) {
            Arrays.fill(i, -1);
        }}
        return helper(arr, 0, budget, dp,0);
    }
}