class Solution {
   
    private int[] helper(int[] nums, int i, int j, int[][][] dp) {
        if (i > nums.length || j > nums.length) {
            return new int[] { 0, 1 };
        }
        if (dp[i][j][0] != -1) {
            return dp[i][j];
        }
        int[] pick = new int[] { 0, 0 };
        int[] skip = helper(nums, i + 1, j, dp);

        if (j == 0 || nums[j - 1] < nums[i - 1]) {
            pick = helper(nums, i + 1, i, dp);
            pick = new int[] { pick[0] + 1, pick[1] };
        }

        if (pick[0] > skip[0]) {
            return dp[i][j] = pick;
        }
        if (pick[0] < skip[0]) {
            return dp[i][j] = skip;
        }
        return dp[i][j] = new int[] { pick[0], pick[1] + skip[1] };
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
       
        int[][][] dp = new int[n + 1][n + 1][2];
        for (int[][] i : dp) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }
        int[] x = helper(nums, 1, 0, dp);
        //System.out.println(x);
        return x[1];
    }
}