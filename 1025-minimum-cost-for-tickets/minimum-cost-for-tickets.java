class Solution {
    private int helper(int[] days, int[] costs, int i, int last,int[][] dp) {
        if (i >= days.length ) {
            return 0;
        }
        if(dp[i][last]!=-1)
        {
            return dp[i][last];
        }
        int skip = Integer.MAX_VALUE, notSkip = Integer.MAX_VALUE;
        if (last >= days[i]) {
            // for (int j = 0; j < 3; j++) {
            //     int day = 0;
            //     if (j == 0) {
            //         day = 1;
            //     } else if (j == 1) {
            //         day = 7;
            //     } else if (j == 2) {
            //         day = 30;
            //     }
            //     skip = Math.min(skip, costs[j] + helper(days, costs, i + 1, days[i] + day-1,dp));
            // }
            notSkip = Math.min(notSkip, helper(days, costs, i + 1, last,dp));
        } else {
            for (int j = 0; j < 3; j++) {
                int day = 0;
                if (j == 0) {
                    day = 1;
                } else if (j == 1) {
                    day = 7;
                } else if (j == 2) {
                    day = 30;
                }
                notSkip = Math.min(notSkip, costs[j] + helper(days, costs, i + 1, days[i] + day-1,dp));
            }
        }
        return dp[i][last]=Math.min(skip, notSkip);
    }

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[][] dp = new int[n+1][1000];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(days, costs, 0, 0,dp);
    }
}

/*

    1 4 6 7 8 20
    Each day we have 3 options 1d,7d,30
    iterate through index and find answer for all 3 possibilities 
    n days, 3 options
    Time complexity - 3^n
*/