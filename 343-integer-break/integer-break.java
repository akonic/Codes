class Solution {
    private int check(int[] nums)
    {
        int count=0,prod=0;
        for(int i=0;i<nums.length;i++)
        {   int pro=0;
            if(nums[i]>=0)
            {
                count++;
                pro=1;
                int x=nums[i];
                while(x>0)
                {
                    pro*=nums[i];
                    x--;
                }
            }
            prod+=pro;
        }
        if(count>=2)
        {
            return prod;
        }
        return -1;
    }
    private int helper(int n,int i,int count,int original,int[][][] dp)
    {   //System.out.println(n);
        if(n==0 && count>=2)
        {
            return 1; 
        }
        if(n<0 || (n==0 && count<2) || i>original)
        {
            return 0;
        }
        if(dp[n][count][i]!=-1)
        {
            return dp[n][count][i];
        }
        int pick = i*helper(n-i,i,count+1,original,dp);
        int notPick = helper(n,i+1,count,original,dp);

        return dp[n][count][i] = Math.max(pick,notPick);
    }
    public int integerBreak(int n) {
        int[][][] dp = new int[59][59][59];
        for(int[][] i : dp)
        {
            for(int[] j : i)
            {
                Arrays.fill(j,-1);
            }
        }
        return helper(n,1,0,n,dp);

    }
}