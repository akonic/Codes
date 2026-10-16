class Solution {
    private int helper(int[] arr, int curr, int sign,int[][] dp) {
        if (curr == arr.length) {
            return 0;
        }
        if(dp[curr][sign]!=-1)
        {
            return dp[curr][sign];
        }
        if (sign == 0) {
            int a = 1 + Math.max(helper(arr, curr + 1, 1,dp), helper(arr, curr + 1, 2,dp));
            int b = helper(arr, curr + 1, 0,dp);
            return dp[curr][sign]=Math.max(a, b);
        } else if (sign == 1) {
            if (curr - 1 >= 0 && arr[curr] < arr[curr - 1]) {
                return dp[curr][sign]=1 + helper(arr, curr + 1, 2,dp);
            }
            return dp[curr][sign]=0;
        } else { 
            if (curr - 1 >= 0 && arr[curr] > arr[curr - 1]) {
                return dp[curr][sign]=1 + helper(arr, curr + 1, 1,dp);
            }
            return dp[curr][sign]=0;
        }
    }

    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][3];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(arr, 0, 0,dp);
    }
}