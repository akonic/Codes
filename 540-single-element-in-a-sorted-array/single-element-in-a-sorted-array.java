class Solution {
    private int find(int[] nums,int i,int j)
    {
        int mid = i +(j-i)/2;
        int x=-1,y=-1;
        if(i>j)
        {
            return -1;
        }
        if(mid-1>=0 && mid+1<nums.length)
        {
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1])
            {
                return nums[mid];
            }
            x=find(nums,i,mid-1);
            y=find(nums,mid+1,j);
        }
        else if(mid-1>=0)
        {
            if(nums[mid]!=nums[mid-1])
            {
                return nums[mid];
            }
        }
        else if(mid+1<nums.length)
        {
            if(nums[mid]!=nums[mid+1])
            {
                return nums[mid];
            }
        }
        return Math.max(x,y);
    }
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        if(n==1)
        {
            return nums[0];
        }
        return find(nums,0,nums.length-1);
    }
}