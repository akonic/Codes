class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int curr=0,ans=0;
        for(int i=1;i<n-1;i++)
        {
            if(nums[i]-nums[i-1]==nums[i+1]-nums[i])
            {
                curr++;
            }
            else{
                if(curr>0)
                {
                    long x = curr;
                  //  System.out.println(x);
                    long sum = x * (x+1)  /(long)2;
                    ans+=(int)sum;
                }
                curr=0;
            }
        }
        if(curr>0)
                {
                    long x = curr;
                   // System.out.println(x);
                    long sum = x * (x+1)  /(long)2;
                    ans+=(int)sum;
                }
        return ans;
    }
}