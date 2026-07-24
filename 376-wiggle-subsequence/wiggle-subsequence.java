class Solution {
    private int helper(int[] nums,int i,int prev,int turn,int[][][] dp)
    {
        if(i>=nums.length )
        {
            return 0;
        }
        if(prev==-1)
        {
            return Math.max(1+helper(nums,i+1,0,0,dp),helper(nums,i+1,prev,0,dp));
        }
        if(dp[i][prev+1][turn]!=-1)
        {
            return dp[i][prev+1][turn];
        }
        int a = Integer.MIN_VALUE,b=Integer.MIN_VALUE;
        if(turn==0)
        {
            if(nums[i]-nums[prev]>0)
            {
                turn=1;
            }
            else if(nums[i]-nums[prev]<0)
            {
                turn=2;
            }
            int x=1;
            if(turn==0)
            {
                x=0;
            }
             a = x+helper(nums,i+1,i,turn,dp);
        }
        if(turn==1)
        {
            if(nums[i]-nums[prev]<0)
            {
                a= 1+helper(nums,i+1,i,2,dp);
            }
            
        }
        if(turn == 2)
        {
            if(nums[i]-nums[prev]>0)
            {
                a= 1+helper(nums,i+1,i,1,dp);
            } 
        }
        b=helper(nums,i+1,prev,turn,dp);
        return dp[i][prev+1][turn]= Math.max(a,b);
    }
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        if(n<=1)
        {
            return n;
        }
        int[][][] dp = new int[n+1][n+2][3];
        for(int[][] i : dp)
        {
            for(int[] j : i)
            {
                Arrays.fill(j,-1);
            }
        }
        return helper(nums,0,-1,0,dp);
    }
}