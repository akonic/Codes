class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int x=0,y=101;
        for(int i: nums)
        {
            x=Math.max(x,i);
            y=Math.min(y,i);
        }
        boolean[] hash = new boolean[x+1];
        for(int i : nums)
        {
            hash[i]=true;
        }
        List<Integer> ans = new  ArrayList<>();
        for(int i=y;i<=x;i++)
        {
            if(!hash[i])
            {
                ans.add(i);
            }
        }
        return ans;
    }
}