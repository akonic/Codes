class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int[] nums = new int[n*m];
        int c=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                nums[c]=grid[i][j];c++;
            }
        }
        if(c==1)
        {
            return 0;
        }
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            int p = Math.abs(median-nums[i]);
            if(p%x!=0)
            {
                return -1;
            }
            ans+=(p/x);
        }
        return ans;
    }
}