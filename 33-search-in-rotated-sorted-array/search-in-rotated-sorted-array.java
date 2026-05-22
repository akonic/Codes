class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int i=0;int j=n-1;
        int mid=0;
        while(i<=j)
        {
            mid=(i+j)/2;
            if(target==nums[mid])
            {
                return mid;
            }
            else if(nums[i]<=nums[mid])  
            {
                if(target>=nums[i] && target<nums[mid])
                    j=mid-1;
                else
                    i=mid+1;
            }
            else  
            {
                if(target>nums[mid] && target<=nums[j])
                    i=mid+1;
                else
                    j=mid-1;
            }

        }
        if(nums[mid]==target)
        {
            return mid;
        }
        return -1;
    }
}