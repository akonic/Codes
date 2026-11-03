class Solution {
    public int minMoves(int[] nums) {
        int x=-1;
        for(int i : nums)
        {
            x=Math.max(x,i);
        }
        int ans=0;
        for(int i : nums)
        {
            ans+=(x-i);
        }
        return ans;
    }
}