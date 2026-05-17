class Solution {
    private boolean helper(int[] nums,int i,int[] visited)
    {
        if(i==nums.length-1)
        {
            return true;
        }
        visited[i]=1;
        boolean a= false;
        for(int j=1;j<=nums[i];j++)
        {
            if(i+j<nums.length && visited[i+j]==-1)
            {
                a= a || helper(nums,i+j,visited);
            }
        }
        return a;

    }
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int jump=0;
        for(int i=0;i<n;i++)
        {
            if(i>jump) return false;
            jump=Math.max(jump,i+nums[i]);
        }
        return true;
    }
}