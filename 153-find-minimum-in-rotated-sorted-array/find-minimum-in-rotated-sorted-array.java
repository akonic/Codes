class Solution {
    private int index(int[] nums)
    {
        int l=0,r=nums.length-1;
        while(l<r)
        {
            int mid = l + (r-l)/2;
            if(nums[mid]>nums[r])
            {
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return nums[r];
    }
    public int findMin(int[] nums) {
        return index(nums);
    }
}