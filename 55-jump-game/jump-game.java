class Solution {
    private boolean helper(int[] nums,int i,int[] visited)
    {
        if(i==nums.length-1)
        {
            return true;
        }
        boolean a= false;
        for(int j=1;j<=nums[i];j++)
        {
            if(i+j<nums.length && visited[i+j]==-1)
            {
                visited[i+j]=1;
                a= a || helper(nums,i+j,visited);
            }
        }
        return a;

    }
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int[] visited = new int[n];
        Arrays.fill(visited,-1);
        visited[0]=1;
        return helper(nums,0,visited);
    }
}