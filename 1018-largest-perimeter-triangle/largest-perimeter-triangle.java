class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int k=n-1;
        int i=n-2,j=n-3;
        while(i>=0 && j>=0 && k>=0)
        {
            if(nums[k]<nums[i]+nums[j])
            {
                return nums[i]+nums[j]+nums[k];
            }
            else 
            {
                k--;i--;j--;
            }
        }
        return 0;
    }
}