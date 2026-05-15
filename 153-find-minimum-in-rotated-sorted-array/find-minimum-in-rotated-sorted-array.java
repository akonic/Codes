class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        if(n==1)
        {
            return nums[0];
        }
        int i=0,j=n-1;
        while(i<j)
        {
            if(nums[i]<nums[j])
            {
                return nums[i];
            }
            else{
                int mid=(i+j)/2;
                
                if(i==j-1)
                {
                    return Math.min(nums[i],nums[j]);
                }
                else if(nums[mid]<nums[i])
                {
                   
                    j=mid;
                }
                else if(nums[mid]>nums[i])
                {
                   
                    i=mid;
                }
                
            }
        }
        return 0;
    }
}