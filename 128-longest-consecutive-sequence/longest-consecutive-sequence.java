class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        TreeMap<Integer,Integer> mp = new TreeMap<>();
        int ans=1;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            mp.put(nums[i],2);
        }
         int len=1;
        for(Map.Entry<Integer,Integer> e : mp.entrySet())
        {
           len=1;
            int p=e.getKey();
            while(mp.containsKey(p+1) && mp.get(p+1)!=-1)
            {
                p++;
                len++;
                mp.replace(p,-1);
            }
            ans=Math.max(ans,len);
        }
         ans=Math.max(ans,len);
        return ans;
    }
}