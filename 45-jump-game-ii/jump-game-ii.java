class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<=Math.min(nums[i]+i,n-1);j++)
            {
                dist[j]=Math.min(dist[j],1+dist[i]);
            }
            
        }
        return dist[n-1];
    
    }
}