class Solution {
    private boolean checkOdd(int[] nums)
    {
        int n=nums.length;
        boolean odd=false;
        for(int i=0;i<n;i++)
        {
            if(nums[i]%2==1)
            {
                odd=true;
            }
            else if(nums[i]%2==0 && !odd)
            {
                return false;
            }
        }
        return true;
    }
    private boolean checkEven(int[] nums)
    {  int n=nums.length;
        boolean odd=false;
        for(int i=0;i<n;i++)
        {
            if(nums[i]%2==1 )
            {
                if(!odd)
                {
                    return false;
                }
                odd=true;
            }

        }
        return true;
    }

    public boolean uniformArray(int[] nums1) {
        Arrays.sort(nums1);
        if(checkOdd(nums1))
        {
            return true;
        }
        if(checkEven(nums1))
        {
            return true;
        }
        return false;
    }
}