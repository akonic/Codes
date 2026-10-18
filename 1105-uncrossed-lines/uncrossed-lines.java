class Solution {

    private int helper(int[] nums1, int[] nums2, int i, int j,int[][] dp) {
        if (i >= nums1.length || j >= nums2.length) {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int p = 0, q = 0;
        if (nums1[i] == nums2[j]) {
            p = 1 + helper(nums1, nums2, i + 1, j + 1,dp);
        }
        q = Math.max(helper(nums1, nums2, i, j + 1,dp), helper(nums1, nums2, i + 1, j,dp));
        return dp[i][j]=Math.max(p, q);
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n][m];
        for(int[] i : dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(nums1, nums2, 0, 0,dp);
    }
}