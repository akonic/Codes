class Solution {
    // private int helper(int[] nums, int i, int prev, int[][] dp) {
    //     if (i == nums.length) {
    //         return 0;
    //     }
    //     if (dp[i][prev] != -1) {
    //         return dp[i][prev];
    //     }
    //     int pick = 0, notPick = 0;
    //     if (prev == 0) {
    //         pick = 1 + helper(nums, 1, 1, dp);
    //     } else if (nums[i] % nums[prev - 1] == 0) {
    //         pick = 1 + helper(nums, i + 1, i + 1, dp);
    //     }
    //     notPick = helper(nums, i + 1, prev, dp);
    //     return dp[i][prev] = Math.max(pick, notPick);
    // }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int x = 1,ind=0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(nums[j]%nums[i]==0)
                {
                    dp[j]=Math.max(dp[j],1+dp[i]);
                }

            }
            if(dp[i]>x)
            {
                x=dp[i];ind=i;
            }
        }
        ls.add(nums[ind]);
        int j=ind-1;
        while(x>0 && j>=0)
        {
            if(nums[ind]%nums[j]==0 && dp[j]==dp[ind]-1)
            {
                ls.add(nums[j]);
                ind=j;
            }
            j--;
        }
       

        return ls;
    }
}