class Solution {
    public int maximumProduct(int[] nums) {
        int ans=Integer.MIN_VALUE;
        int n=nums.length;
        Arrays.sort(nums);
        ans=Math.max(ans,nums[0]*nums[1]*nums[n-1]);
        ans=Math.max(ans,nums[n-3]*nums[n-2]*nums[n-1]);
        
        return ans;
    }
}