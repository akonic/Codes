class Solution {
    private int helper(int[] nums,int i,int j)
    {
        if(i>j)
        {
            return 0;
        }
        if(i==j)
        {
            return nums[i];
        }
        int take_i = nums[i]+Math.min(helper(nums,i+2,j),helper(nums,i+1,j-1));
        int take_j = nums[j]+Math.min(helper(nums,i+1,j-1),helper(nums,i,j-2));

        return Math.max(take_i,take_j);
    }
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i:nums)
        {
            sum+=i;
        }
        int score = helper(nums,0,n-1);
        if(score>=sum-score)
        {
            return true;
        }
        return false;
    }
}