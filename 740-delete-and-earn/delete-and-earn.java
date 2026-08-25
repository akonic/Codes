class Solution {
    private int helper(int[] nums, int i,int[] dp) {
        if (i >= nums.length) {
            return 0;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        int pick = 0, skip = 0;
        int a = nums[i];
        int c = 0, x = i;
        while (x < nums.length && nums[x] == a) {
            c++;
            x++;
        }
        while (x < nums.length && nums[x]+1 == a) {
            x++;
        }

        pick = c * a + helper(nums, x,dp);
        skip = helper(nums, i + 1,dp);

        return dp[i]=Math.max(pick, skip);
    }

    public int deleteAndEarn(int[] nums) {
       
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        for (int i = 0; i < n / 2; i++) {
            int x = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = x;
        }
        int p = helper(nums, 0,dp);
        //System.out.println(p);
        return p;
    }
}