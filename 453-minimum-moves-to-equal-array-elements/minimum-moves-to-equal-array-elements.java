class Solution {
    public int minMoves(int[] nums) {
        int ans=0;int prev=0;
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=n-1;i>=0;i--)
        {
            if(ans+nums[i]==ans+nums[0])
            {
                return ans;
            }
            ans+=nums[i]-nums[0];
        }
        return ans;
    }
}